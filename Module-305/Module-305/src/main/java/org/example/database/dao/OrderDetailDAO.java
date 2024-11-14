package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.OrderDetail;
import org.example.database.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();


    public void update(OrderDetail orderDetail) {
        // for hibernate to do an update, it needs the product to already exist in the database otherwise its an error
        Session session = factory.openSession();

        // starting a database transaction
        session.getTransaction().begin();

        // in an older style of hibernate we need to use the merge function when we want to do an update
        try {
            session.merge(orderDetail);
            session.getTransaction().commit();
        } catch ( Exception e ) {
            session.getTransaction().rollback();
        }

        session.close();
    }

    public void create(OrderDetail orderDetail) {
        Session session = factory.openSession();

        // starting a database transaction
        session.getTransaction().begin();

        // in an older style of hibernate we need to use the persist function when we want to create a new record
        session.persist(orderDetail);

        session.getTransaction().commit();

        session.close();
    }

    public void delete(OrderDetail orderDetail) {
        Session session = factory.openSession();

        // starting a database transaction
        session.getTransaction().begin();

        // in an older style of hibernate we need to use the persist function when we want to create a new record
        session.delete(orderDetail);

        session.getTransaction().commit();

        session.close();
    }

    // -------------------- blow here is our queries --------------------------

    // ** This query gets created in every single DAO you make **
    public OrderDetail findByOrderId(Integer id) {
        // Hibernate queries must use the java names from the entites
        // this is HQL
        String hqlQuery = "SELECT od FROM OrderDetail od WHERE od.orderId = :orderId";
        // this is what is called native SQL - the native query only included here to show the difference
        // between HQL and native
        //String nativeSqlQuery = "select * from products where id = ?";

        // this is needed to get the database connection and let hibernate run the query
        Session session = factory.openSession();

        // hibernate uses this typed query to execute the query and fill "hydrate" the entity with the data from the database
        // passing in the HQL query and setting the datatype for hibernate to use
        TypedQuery<OrderDetail> query = session.createQuery(hqlQuery, OrderDetail.class);

        // now we can set the parameter on the query
        // the int id is the value that we want to substitute into the query at the
        // :productId location
        query.setParameter("orderId", id);

        // we know this is a primary key so this query will return 0 recrods or 1 record
        // if the product was not found in the database we want to return null from our function
        // otherwise we want to return our product
        // hibernate will run the query and create a new product entity and fill it up with the data for us
        try {
            OrderDetail result = query.getSingleResult();
            return result;
        } catch ( Exception e ) {
            // no result was found .. for any number of reasons
            return null;
        } finally {
            // have to close the session at the end .. which tells hibernate to give the connection back to the pool
            session.close();
        }
    }

    /**
     * Return a list of products that match the name
     *
     * A function that retuns a list will always return a list even if the query returns 0 results
     */
    public List<OrderDetail> searchByProductId(int orderId) {
        // WARNING !!!! HQL when doing a like statement needs special care in using some other method of concatinating the wild cards
        // into the query
        String hqlQuery = "SELECT od FROM OrderDetail od WHERE od.productId = :orderId";

        Session session = factory.openSession();

        TypedQuery<OrderDetail> query = session.createQuery(hqlQuery, OrderDetail.class);
        query.setParameter("orderId", orderId);

        // will always return a list
        try {
            List<OrderDetail> result = query.getResultList();
            return result;
        } catch ( Exception e ) {
            // if an error happens
            // we should do some real error checking here
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }
    public OrderDetail findByOrderIdAndProductId(int orderId, int productId) {
        Session session = factory.openSession();

        String hql = "SELECT od from OrderDetail od where od.orderId = :orderId and od.productId = :productId";

        TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
        query.setParameter("orderId", orderId);
        query.setParameter("productId", productId);

        try{
            OrderDetail orderDetail = query.getSingleResult();
            return orderDetail;
        }catch(Exception e) {
            return null;
        }finally {
            session.close();
        }
    }
//    public List<Product> findByOrderId(int orderId) {
//        // I want to see all products that are in an order
//        return null;
//    }
}
