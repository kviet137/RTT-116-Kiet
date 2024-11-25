package org.example.database.dao;

import org.example.database.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeDAOTest2 {

    // TODO !!!!!!!!! ITS NOT GOOD PRACTICE TO PUT VARIABLES INSIDE TEST CASES


    private EmployeeDAO employeeDAO = new EmployeeDAO();
    Employee newEmployee = new Employee();
    @Test
    public void createEmployeeTest() { // <<---- need to change the RETURN TYPE in createEmployee for it to RETURN THE EMPLOYEE OBJECT in the employeeDAO


        newEmployee.setOfficeId(2);
        newEmployee.setLastname("2LastName");
        newEmployee.setFirstname("2FirstName");
        newEmployee.setExtension("2Extension");
        newEmployee.setEmail("2Email");
        newEmployee.setReportsTo(2);
        newEmployee.setJobTitle("2JobTitle");
        newEmployee.setVacationHours(2);
        newEmployee.setProfileImageUrl("2ProfileImageUrl");
        //newEmployee = employeeDAO.create(newEmployee);
        employeeDAO.update(newEmployee);

        Assertions.assertNotNull(newEmployee);

        System.out.println("create:" + newEmployee.getId());


    }

    @Test
    public void updateTest() {



        System.out.println("update :" +newEmployee.getId());

        //Employee updateEmployee = employeeDAO.findById(newEmployee.getId());

        newEmployee.setOfficeId(3);
        newEmployee.setLastname("3LastName");
        newEmployee.setFirstname("3FirstName");
        newEmployee.setExtension("3Extension");
        newEmployee.setEmail("3Email");
        newEmployee.setReportsTo(3);
        newEmployee.setJobTitle("3JobTitle");
        newEmployee.setVacationHours(3);
        newEmployee.setProfileImageUrl("3ProfileImageUrl");
        employeeDAO.update(newEmployee);


        Assertions.assertNotNull(newEmployee);
        Assertions.assertEquals(3, newEmployee.getVacationHours());
        Assertions.assertEquals("3LastName", newEmployee.getLastname());
        Assertions.assertEquals("3FirstName", newEmployee.getFirstname());
        Assertions.assertEquals("3Extension", newEmployee.getExtension());
        Assertions.assertEquals("3Email", newEmployee.getEmail());
        Assertions.assertEquals("3ProfileImageUrl", newEmployee.getProfileImageUrl());

    }

    @Test
    public void deleteTest() {

        employeeDAO.deleteById(1724);
        Assertions.assertNull(employeeDAO.findById(1724));


    }
}
