package com.example.module309.database.dao;


import com.example.module309.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.firstName = :firstName") //this is a JPA/HQL/JQL or hybernate query
    List<Employee> findByFirstName(String firstName);


    Employee findById(Integer id);

    @Query(value = "select * from employees order by lastname asc;", nativeQuery = true)
    List<Employee> findAllEmployee();

}
