package com.prt.cmapp.dao;

import com.prt.cmapp.entity.Customer;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> getAllCustomers() {
        Session session = entityManager.unwrap(Session.class);
        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        List<Customer> customers = query.getResultList();
        System.out.println("Hibernate");
        return customers;
    }

    @Override
    public Customer getCustomerById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Customer customer = session.get(Customer.class,id);
        return customer;
    }

    @Override
    public void saveCustomer(Customer newCustomer) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(newCustomer);
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from Customer where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
