package org.example;

import org.example.database.dao.CustomerDAO;
import org.example.database.dao.ProductDAO;
import org.example.database.entity.Customer;
import org.example.database.entity.Product;

import java.util.List;

public class RunTest {

        public static void main(String[] args) {
            CustomerDAO customerDAO = new CustomerDAO();

            List<Customer> c = customerDAO.findCustomerWithName("Peter");
            for (Customer customer : c) {
                System.out.println(customer);
            }



        }
    }

