package com.prt.cmapp.service;

import com.prt.cmapp.dao.CustomerDao;
import com.prt.cmapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    @Qualifier(value = "customerDaoJpaImpl")
    private CustomerDao customerDao;

    @Override
    @Transactional
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerDao.getAllCustomers();
        return customers;
    }

    @Override
    @Transactional
    public Customer getCustomerById(int id) {
        Customer customer = customerDao.getCustomerById(id);
        return customer;
    }

    @Override
    @Transactional
    public void saveCustomer(Customer newCustomer) {
        customerDao.saveCustomer(newCustomer);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDao.deleteCustomer(id);
    }
}
