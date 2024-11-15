package org.example.database.dao;

import org.example.database.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeeDAOTest {

    private EmployeeDAO employeeDAO = new EmployeeDAO();


//    @TestInstance(TestInstance.Lifecycle.PER_CLASS)    <----needed for hw on 11/15/2024
//    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)


    @Test
    public void findByIdTest() {
        //given
        int givenId = 1188;

        //when
        Employee actualEmployee = employeeDAO.findById(givenId);

        //then
        Assertions.assertEquals(givenId, actualEmployee.getId());

    }


    @Test
    public void findByFirstNameTest() {

        String givenFirstName = "Leslie";

        List<Employee> actualFirstName = employeeDAO.findByFirstName(givenFirstName);

        Assertions.assertTrue(actualFirstName.size() == 2);

    }

    @Test
    public void createEmployeeTest() { // <<---- need to change the RETURN TYPE in createEmployee for it to RETURN THE EMPLOYEE OBJECT in the employeeDAO
        Employee newEmployee = new Employee();

        newEmployee.setOfficeId(2);
        newEmployee.setLastname("2LastName");
        newEmployee.setFirstname("2FirstName");
        newEmployee.setExtension("2Extension");
        newEmployee.setEmail("2Email");
        newEmployee.setReportsTo(2);
        newEmployee.setJobTitle("2JobTitle");
        newEmployee.setVacationHours(2);
        newEmployee.setProfileImageUrl("2ProfileImageUrl");
        employeeDAO.create(newEmployee);
        employeeDAO.update(newEmployee);

        Assertions.assertNotNull(newEmployee);

        System.out.println("create:" + newEmployee.getId());
        
    }

    @Test
    public void updateTest() {
        Employee newEmployee = new Employee();

        System.out.println("update :" +newEmployee.getId());

        Employee updateEmployee = employeeDAO.findById(newEmployee.getId());

        updateEmployee.setOfficeId(3);
        updateEmployee.setLastname("3LastName");
        updateEmployee.setFirstname("3FirstName");
        updateEmployee.setExtension("3Extension");
        updateEmployee.setEmail("3Email");
        updateEmployee.setReportsTo(3);
        updateEmployee.setJobTitle("3JobTitle");
        updateEmployee.setVacationHours(3);
        updateEmployee.setProfileImageUrl("3ProfileImageUrl");
        employeeDAO.update(updateEmployee);


        Assertions.assertNotNull(updateEmployee);
        Assertions.assertEquals(3, updateEmployee.getVacationHours());
        Assertions.assertEquals("3LastName", updateEmployee.getLastname());
        Assertions.assertEquals("3FirstName", updateEmployee.getFirstname());
        Assertions.assertEquals("3Extension", updateEmployee.getExtension());
        Assertions.assertEquals("3Email", updateEmployee.getEmail());
        Assertions.assertEquals("3ProfileImageUrl", updateEmployee.getProfileImageUrl());

    }

    @Test
    public void deleteTest() {

       employeeDAO.deleteById(1724);
       Assertions.assertNull(employeeDAO.findById(1724));


    }
}
