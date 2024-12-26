package com.example.module309.controller;



import com.example.module309.database.dao.EmployeeDAO;
import com.example.module309.database.entity.Customer;
import com.example.module309.database.entity.Employee;
import com.example.module309.form.CreateCustomerFormBean;
import com.example.module309.form.CreateEmployeeFormBean;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@PreAuthorize("hasAuthority('CUSTOMER')")
public class EmployeeController {


    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/employee/search")
    public ModelAndView search(@RequestParam(required = false) String firstName) {

        ModelAndView response = new ModelAndView("employee/search");

        response.addObject("search", firstName);
        if (firstName != null) {
            List<Employee> employees = employeeDAO.findByFirstName(firstName);
            response.addObject("employeesKey",employees);
        }

        return response;
    }

    @GetMapping("/employee/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView();

        response.setViewName("employee/create");

        return response;

    }

    @GetMapping("/employee/createEmployee")
    public ModelAndView createEmployeeSubmit (@Valid CreateEmployeeFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();

        response.setViewName("employee/create"); //<--this page will use employee/create html page for the view

        LOG.debug(form.toString());

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                LOG.debug(error.toString());
            }
            response.setViewName("employee/create");
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
        }else{
            Employee employee = employeeDAO.findById(form.getId());
            if ( employee == null ) {
                employee = new Employee();
            }

            employee.setOfficeId(7);
            employee.setFirstName(form.getFirstName());
            employee.setLastName(form.getLastName());
            employee.setEmail(form.getEmail());
            employee.setExtension(form.getExtension());
            employee.setReportsTo(form.getReportsTo());
            employee.setJobTitle(form.getJobTitle());

            employeeDAO.save(employee);
            response.setViewName("redirect:/employee/edit/" + employee.getId() );

        }

        return response;
    }

    @GetMapping("/employee/edit/{employeeId}")
    public ModelAndView edit(@PathVariable Integer employeeId) {
        ModelAndView response = new ModelAndView();

        response.setViewName("employee/create");
        Employee employee = employeeDAO.findById(employeeId);
        CreateEmployeeFormBean form = new CreateEmployeeFormBean();

        form.setId(employee.getId());
        form.setOfficeId(employee.getOfficeId());
        form.setFirstName(employee.getFirstName());
        form.setLastName(employee.getLastName());
        form.setEmail(employee.getEmail());
        form.setExtension(employee.getExtension());
        form.setReportsTo(employee.getReportsTo());
        form.setJobTitle(employee.getJobTitle());

        response.addObject("form", form); //<<--this will allow all the inputs that the users type in from the webpage stay after the user click submit


        return response;

    }
}