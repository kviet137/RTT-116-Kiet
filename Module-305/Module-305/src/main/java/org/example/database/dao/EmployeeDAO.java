package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Employee;
import org.example.database.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    // old style: make session factory for all DAO
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void update(Employee employee) {
        // for hibernate
        // update: the product has already existed to work without error
        Session session = factory.openSession();
        session.beginTransaction();
        session.merge(employee);
        session.getTransaction().commit();
        session.close();
    }

    public Employee create(Employee employee) {
        // for hibernate
        // update: the product has already existed to work without error
        Session session = factory.openSession();
        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();
        session.close();

        return employee;
    }

    public void deleteByProduct(Employee employee) {
        // for hibernate
        // update: the product has already existed to work without error
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            session.delete(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    public void deleteById(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class, id);
        try {
            session.delete(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    public Employee findById(int employeeId) {
        Session session = factory.openSession();
        String hqlQuery = "SELECT e FROM Employee e WHERE id = :employeeId";


        TypedQuery<Employee> query = session.createQuery(hqlQuery, Employee.class);
        query.setParameter("employeeId", employeeId);

        try {
            Employee employee = query.getSingleResult();
            return employee;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Employee> findByFirstName(String name) {
        Session session = factory.openSession();

        String hqlName = "SELECT e FROM Employee e WHERE e.firstname = :cName";

        TypedQuery<Employee> query = session.createQuery(hqlName, Employee.class);
        query.setParameter("cName", name);

        try{
            List<Employee> resultNameList = query.getResultList();
            return resultNameList;

        }catch(Exception e) {
            return new ArrayList<>();

        }finally {
            session.close();
        }

    }
}