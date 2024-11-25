package org.example.database.dao;

import org.example.database.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeeDAOTest {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    Employee createdEmployee;


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

        System.out.println("before create:" + newEmployee);
        newEmployee.setOfficeId(2);
        newEmployee.setLastname("2LastName");
        newEmployee.setFirstname("2FirstName");
        newEmployee.setExtension("2Extension");
        newEmployee.setEmail("2Email");
        newEmployee.setReportsTo(2);
        newEmployee.setJobTitle("2JobTitle");
        newEmployee.setVacationHours(2);
        newEmployee.setProfileImageUrl("2ProfileImageUrl");
        createdEmployee = employeeDAO.create(newEmployee);
        employeeDAO.update(createdEmployee);

        System.out.println("after create:" + newEmployee);

        Assertions.assertNotNull(createdEmployee);

        System.out.println("???:" + createdEmployee.getId());
        System.out.println("before update:" + newEmployee);

        createdEmployee.setOfficeId(3);
        createdEmployee.setLastname("3LastName");
        createdEmployee.setFirstname("3FirstName");
        createdEmployee.setExtension("3Extension");
        createdEmployee.setEmail("3Email");
        createdEmployee.setReportsTo(3);
        createdEmployee.setJobTitle("3JobTitle");
        createdEmployee.setVacationHours(3);
        createdEmployee.setProfileImageUrl("3ProfileImageUrl");
        employeeDAO.update(createdEmployee);

        System.out.println("after update:" + newEmployee);

        Assertions.assertNotNull(createdEmployee);
        Assertions.assertEquals(3, createdEmployee.getVacationHours());
        Assertions.assertEquals("3LastName", createdEmployee.getLastname());
        Assertions.assertEquals("3FirstName", createdEmployee.getFirstname());
        Assertions.assertEquals("3Extension", createdEmployee.getExtension());
        Assertions.assertEquals("3Email", createdEmployee.getEmail());
        Assertions.assertEquals("3ProfileImageUrl", createdEmployee.getProfileImageUrl());


        System.out.println("before delete:" + createdEmployee);
        employeeDAO.deleteById(createdEmployee.getId());
        Assertions.assertNull(employeeDAO.findById(createdEmployee.getId()));
        System.out.println("after delete:" + createdEmployee); // this object still exists in java but the datas it created gets deleted in the DATABASE
        System.out.println("after delete and find the id INSIDE the DATABASE" + employeeDAO.findById(createdEmployee.getId()));
    }

    @Test
    public void updateTest() {
        Employee newEmployee = new Employee();


        System.out.println("update :" +createdEmployee.getId());

        Employee updateEmployee = employeeDAO.findById(newEmployee.getId());

        createdEmployee.setOfficeId(3);
        createdEmployee.setLastname("3LastName");
        createdEmployee.setFirstname("3FirstName");
        createdEmployee.setExtension("3Extension");
        createdEmployee.setEmail("3Email");
        createdEmployee.setReportsTo(3);
        createdEmployee.setJobTitle("3JobTitle");
        createdEmployee.setVacationHours(3);
        createdEmployee.setProfileImageUrl("3ProfileImageUrl");
        employeeDAO.update(createdEmployee);


        Assertions.assertNotNull(createdEmployee);
        Assertions.assertEquals(3, createdEmployee.getVacationHours());
        Assertions.assertEquals("3LastName", createdEmployee.getLastname());
        Assertions.assertEquals("3FirstName", createdEmployee.getFirstname());
        Assertions.assertEquals("3Extension", createdEmployee.getExtension());
        Assertions.assertEquals("3Email", createdEmployee.getEmail());
        Assertions.assertEquals("3ProfileImageUrl", createdEmployee.getProfileImageUrl());

    }

    @Test
    public void deleteTest() {

       employeeDAO.deleteById(1724);
       Assertions.assertNull(employeeDAO.findById(1724));


    }
}
