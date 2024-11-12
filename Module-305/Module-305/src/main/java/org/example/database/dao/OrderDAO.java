package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void update(Order order) {
        // for hibernate to do an update, it needs the product to already exist in the database otherwise its an error
        Session session = factory.openSession();

        // starting a database transaction
        session.getTransaction().begin();

        // in an older style of hibernate we need to use the merge function when we want to do an update
        try {
            session.merge(order);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }

        session.close();
    }

    public void create(Order order) {
        Session session = factory.openSession();

        // starting a database transaction
        session.getTransaction().begin();

        // in an older style of hibernate we need to use the persist function when we want to create a new record
        session.persist(order);

        session.getTransaction().commit();

        session.close();
    }

    public void delete(Order order) {
        Session session = factory.openSession();

        // starting a database transaction
        session.getTransaction().begin();

        // in an older style of hibernate we need to use the persist function when we want to create a new record
        session.delete(order);

        session.getTransaction().commit();

        session.close();
    }

    // -------------------- blow here is our queries --------------------------

    // ** This query gets created in every single DAO you make **
    public Order findById(Integer id) {
        // Hibernate queries must use the java names from the entites
        // this is HQL
        String hqlQuery = "SELECT o FROM Order o WHERE o.id = :orderId";
        // select * from orders o join orderdetails on o.id = orderdetails.order_id;
        //String hqlQuery = "SELECT o FROM Order o join OrderDetail  on o.id = OrderDetail.orderId WHERE o.id = :orderId";
        // this is what is called native SQL - the native query only included here to show the difference
        // between HQL and native
        //String nativeSqlQuery = "select * from products where id = ?";

        // this is needed to get the database connection and let hibernate run the query
        Session session = factory.openSession();

        // hibernate uses this typed query to execute the query and fill "hydrate" the entity with the data from the database
        // passing in the HQL query and setting the datatype for hibernate to use
        TypedQuery<Order> query = session.createQuery(hqlQuery, Order.class);

        // now we can set the parameter on the query
        // the int id is the value that we want to substitute into the query at the
        // :productId location
        query.setParameter("orderId", id);

        // we know this is a primary key so this query will return 0 recrods or 1 record
        // if the product was not found in the database we want to return null from our function
        // otherwise we want to return our product
        // hibernate will run the query and create a new product entity and fill it up with the data for us
        try {
            Order result = query.getSingleResult();
            return result;
        } catch (Exception e) {
            // no result was found .. for any number of reasons
            return null;
        } finally {
            // have to close the session at the end .. which tells hibernate to give the connection back to the pool
            session.close();
        }
    }

    /**
     * Return a list of products that match the name
     * <p>
     * A function that retuns a list will always return a list even if the query returns 0 results
     */
    public List<Order> search(int customerId) {
        // WARNING !!!! HQL when doing a like statement needs special care in using some other method of concatinating the wild cards
        // into the query
        String hqlQuery = "SELECT o FROM Order o WHERE o.customerId = :customerId";

        Session session = factory.openSession();

        TypedQuery<Order> query = session.createQuery(hqlQuery, Order.class);
        query.setParameter("customerId", customerId);

        // will always return a list
        try {
            List<Order> result = query.getResultList();
            return result;
        } catch (Exception e) {
            // if an error happens
            // we should do some real error checking here
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

//    public List<Order> findByOrderId(int orderId) {
//        // I want to see all products that are in an order
//        return null;
//    }
}
