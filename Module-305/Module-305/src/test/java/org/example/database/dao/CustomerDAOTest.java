package org.example.database.dao;

import org.example.database.entity.Customer;
import org.example.database.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerDAOTest {

    private CustomerDAO customerDAO = new CustomerDAO();

    @Test
    public void findCustomerByIdTest(){

        // given
        int givenCustomerId = 125;

        // when
        Customer actual = customerDAO.findCustomerById(givenCustomerId);

        //then
        Assertions.assertEquals("Havel & Zbyszek Co", actual.getCustomerName());
        Assertions.assertEquals(givenCustomerId, actual.getId());
        Assertions.assertEquals(0.00, actual.getCreditLimit());

    }
    @Test
    public void createCustomerTest(){
        //given
        Customer givenCustomer = new Customer();

        givenCustomer.setCustomerName("New Customer");
        givenCustomer.setContactFirstname("Eric");
        givenCustomer.setContactLastname("Eric");
        givenCustomer.setPhone("5555551212");
        givenCustomer.setAddressLine1("5555551212");
        givenCustomer.setAddressLine1("222222");
        givenCustomer.setCity("city");
        givenCustomer.setState("asdfasdf");
        givenCustomer.setPostalCode("023432");
        givenCustomer.setCountry("USA");
        givenCustomer.setCreditLimit(234.33);

        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = employeeDAO.findById(1216);
        givenCustomer.setEmployee(employee);


        //when
        Assertions.assertNull(givenCustomer.getId());
        Customer actualCustomer = customerDAO.createCustomer(givenCustomer);

        // then

        Assertions.assertNotNull(actualCustomer.getId());
        Assertions.assertEquals(givenCustomer.getContactFirstname(), actualCustomer.getContactFirstname());

        Assertions.assertEquals(givenCustomer.getContactFirstname(), actualCustomer.getContactFirstname());
        Assertions.assertEquals(givenCustomer.getContactLastname(), actualCustomer.getContactLastname());

        // create an additional assertion to check the employee id is correct
        Assertions.assertEquals(employee.getId(), actualCustomer.getEmployee().getId());

    }

}
