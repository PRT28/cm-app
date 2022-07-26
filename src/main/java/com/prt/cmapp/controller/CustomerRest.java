package com.prt.cmapp.controller;

import com.prt.cmapp.entity.Customer;
import com.prt.cmapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRest {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return customers;
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return customer;
    }

    @PostMapping("/customers")
    public ResponseEntity saveCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        customerService.saveCustomer(customer);
        return new ResponseEntity<>("Customer is saved successfully", HttpStatus.OK);
    }

    @PutMapping("/customers")
    public ResponseEntity updateCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return new ResponseEntity<>("Customer is updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/customers/delete/{customerId}")
    public ResponseEntity deleteCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        if(customer == null) {
            return new ResponseEntity<>("Customer with id "+customerId+" does not exist", HttpStatus.BAD_REQUEST);
        }
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>("Customer is deleted successfully", HttpStatus.OK);
    }
}
