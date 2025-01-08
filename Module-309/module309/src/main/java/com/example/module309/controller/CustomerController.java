package com.example.module309.controller;


import com.example.module309.database.dao.CustomerDAO;
import com.example.module309.database.dao.EmployeeDAO;
import com.example.module309.database.entity.Customer;
import com.example.module309.database.entity.Employee;
import com.example.module309.form.CreateCustomerFormBean;
import com.example.module309.security.AuthenticatedUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

//@Slf4j  <---dont need because it using the lOG as a logger instead
//the Logger is used for loggin debug, info, warning, and error

@Controller
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("customer/ajaxExample")
    public ModelAndView ajaxExample() {
        ModelAndView response = new ModelAndView("customer/ajaxExample");

        return response;
    }

    @ResponseBody
    @GetMapping ("customer/ajaxCall")
    public String ajaxCall(@RequestParam Integer customerId) throws Exception {
        Customer customer = customerDAO.findById(customerId);


        String json = new ObjectMapper().writeValueAsString(customer);
        //http://localhost:8080/customer/ajaxCall?customerId=512

        return json;

    }

    @GetMapping("/customer/search")
    public ModelAndView search(@RequestParam(required = false) String firstName) {

        ModelAndView response = new ModelAndView("customer/search");


        response.addObject("search", firstName);
        if (firstName != null) {
            List<Customer> customers = customerDAO.findByFirstName(firstName);
            response.addObject("customersKey", customers);
        }

        return response;
    }

    @GetMapping("/customer/create")
    public ModelAndView createCustomer() {
        ModelAndView response = new ModelAndView();

        response.setViewName("customer/create");

        List<Employee> employees = employeeDAO.findAllEmployee();
        response.addObject("employeesKey", employees);

        return response;
    }

    @GetMapping("/customer/edit/{customerId}")
    public ModelAndView editCustomer(@PathVariable Integer customerId) {
        ModelAndView response = new ModelAndView();

        response.setViewName("customer/create");
        Customer customer = customerDAO.findById(customerId);
        CreateCustomerFormBean form = new CreateCustomerFormBean();

        form.setId(customer.getId());
        form.setCompanyName(customer.getCustomerName());
        form.setFirstName(customer.getContactFirstname());
        form.setLastName(customer.getContactLastname());
        form.setAddressLine1(customer.getAddressLine1());
        form.setPhone(customer.getPhone());
        form.setCity(customer.getCity());
        form.setCountry(customer.getCountry());
        form.setEmployeeId(customer.getSalesRepEmployeeId());
        // alternate step from above form.setEmployeeId(customer.getEmployee().getId());

        response.addObject("form", form);

        List<Employee> employees = employeeDAO.findAllEmployee();
        response.addObject("employeesKey", employees);


        return response;
    }

    @PostMapping("/customer/createCustomer")
    public ModelAndView createCustomerSubmit(@Valid CreateCustomerFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("customer/create");

        LOG.debug(form.toString());

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                LOG.debug(error.toString());

                List<Employee> employees = employeeDAO.findAllEmployee();
                response.addObject("employeesKey", employees);
            }
            response.setViewName("customer/create");
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
        } else {

            // when this is a create the id in the form will be null
            // when it is an edit the id in the form will be populated with the PK to edit
            // in either case we can try to query the database and its either found or not
            // if its not found in the database its a create
            // if it is found in the database then its an edit
            Customer customer = customerDAO.findById(form.getId());
            if (customer == null) {
                customer = new Customer();
            }


            customer.setCustomerName(form.getCompanyName());
            customer.setContactFirstname(form.getFirstName());
            customer.setContactLastname(form.getLastName());
            customer.setPhone(form.getPhone());
            customer.setAddressLine1(form.getAddressLine1());
            customer.setCity(form.getCity());
            customer.setCountry(form.getCountry());

            // here we are going to deal with saving the upload file to the disk
            LOG.debug("uploaded filename = " + form.getUpload().getOriginalFilename() + " size = " + form.getUpload().getSize());
            // create a new file object that represents the location to save the upload to
            // we know that intellij always assumes the current working directory is the root of the project so we are making
            // a relative URL To the images folder within our project
            String pathToSave = "./src/main/webapp/pub/images/" + form.getUpload().getOriginalFilename();
            // this is a java utility that will read the file from the upload and write it to the file we created above
            // will not take the entire file into memory
            Files.copy(form.getUpload().getInputStream(), Paths.get(pathToSave), StandardCopyOption.REPLACE_EXISTING);
            // this is the url that we will use to display the image in the browser
            // it is an absolute URL based on the webapp folder as it would be used in the html
            String url = "/pub/images/" + form.getUpload().getOriginalFilename();
            customer.setImageUrl(url);


            Employee employee = employeeDAO.findById(form.getEmployeeId());
            customer.setEmployee(employee);

            customerDAO.save(customer);
            response.setViewName("redirect:/customer/edit/" + customer.getId());


        }

        return response;
    }
}

