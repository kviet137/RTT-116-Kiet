package org.example;

import org.example.database.dao.EmployeeDAO;
import org.w3c.dom.ls.LSOutput;

public class RunTest2 {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        employeeDAO.deleteById(1722);
        //<---need to update the id
    }

}
