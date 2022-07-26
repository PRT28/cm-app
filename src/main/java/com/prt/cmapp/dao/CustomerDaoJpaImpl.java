package com.prt.cmapp.dao;

import com.prt.cmapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerDaoJpaImpl implements CustomerDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> getAllCustomers() {
        Query query= entityManager.createQuery("from Customer");
        List<Customer> customers = query.getResultList();
        System.out.println("JPA");
        return customers;
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }

    @Override
    public void saveCustomer(Customer newCustomer) {
        Customer customer = entityManager.merge(newCustomer);
        newCustomer.setId(customer.getId());
    }

    @Override
    public void deleteCustomer(int id) {
        Query query= entityManager.createQuery("delete from Customer where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
