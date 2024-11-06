package org.example;

import java.sql.*;
import java.util.Scanner;

public class IDBCExample {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        String dburl = "jdbc:mysql://localhost:3306/classic_models";
        String user = "root";
        System.out.println("Enter your Database PASSWORD: ");
        String password = sc.nextLine();
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dburl, user, password);
            String SelectSQL = "Select * FROM employees";
            Statement stmt = connection.createStatement();
            ResultSet result =  stmt.executeQuery(SelectSQL);
            while(result.next())
            {
                String EmployeeID  = result.getString("id");
                String fname = result.getString("firstname");
                String lname  = result.getString("lastname");
                System.out.println(EmployeeID +" | " + fname + "|"+ lname );
            }
            connection.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
