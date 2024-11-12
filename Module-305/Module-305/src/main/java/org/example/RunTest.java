package org.example;

import org.example.database.dao.CustomerDAO;
import org.example.database.dao.OrderDAO;
import org.example.database.dao.OrderDetailDAO;
import org.example.database.dao.ProductDAO;
import org.example.database.entity.Customer;
import org.example.database.entity.Order;
import org.example.database.entity.OrderDetail;
import org.example.database.entity.Product;

import java.util.List;

public class RunTest {

        public static void main(String[] args) {
//            CustomerDAO customerDAO = new CustomerDAO();
//
//
//            List<Customer> c = customerDAO.findCustomerWithName("Peter");
//            for (Customer customer : c) {
//                System.out.println(customer);
//            }

            // Todo HW # 3 For any existing order add a new product to that order
            //  with a quantity ordered of 100.    This you can do using the product DAO only.
            //  Create a new order details with the correct information and set the order and
            //  the product on the order details add the order details to the list of orderdetails
            //   on the product and save the product.Do not forget to set both the product and
            //   the order on the new orderdetails obect before saving it. Look at the
            //   class example from today in how I added a custoemr to the emoloyee as a road map.


            int orderID = 10111;

            //Order o = new OrderDAO().findById(orderID);   //<----this shorten the code below


            OrderDetailDAO odDAO = new OrderDetailDAO();

            ProductDAO pDAO = new ProductDAO();

            OrderDAO orderDAO = new OrderDAO();
            Order o = orderDAO.findById(10111);


            if (o != null) {
                System.out.println(o);

                OrderDetail newOrderDetail = new OrderDetail();
                Product newProduct = new Product();

                newProduct.setProductCode("999");
                newProduct.setProductName("Nine");
                newProduct.setProductlineId(7);
                newProduct.setProductScale("Nine Pound");
                newProduct.setProductVendor("Nine Vendor");
                newProduct.setProductDescription("Product 9");
                newProduct.setQuantityInStock(newProduct.getQuantityInStock() + 100);
                newProduct.setBuyPrice(99);
                newProduct.setMsrp(.99);

                pDAO.create(newProduct);
                newOrderDetail.setProduct(newProduct);


                pDAO.update(newProduct);


                try {
                    newOrderDetail.setQuantityOrdered(100);
                    newOrderDetail.setPriceEach(99.99);
                    newOrderDetail.setOrderLineNumber(9);


                    //orderDAO.create(newOrderDetail.getOrder());
                    newOrderDetail.setOrder(o);
                    o.getOrderDetails().add(newOrderDetail);


                    System.out.println("succeed");

                } catch (Exception e) {
                    System.out.println("failed");
                    System.out.println(e);
                } finally {

                    orderDAO.update(o);
                    odDAO.update(newOrderDetail);
                }


            }
            ;



        }
    }

