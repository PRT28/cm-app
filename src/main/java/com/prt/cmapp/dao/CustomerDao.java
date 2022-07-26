package com.prt.cmapp.dao;

import com.prt.cmapp.entity.Customer;

import java.util.List;

public interface CustomerDao {

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(int id);

    public void saveCustomer(Customer newCustomer);

    public void deleteCustomer(int id);
}
