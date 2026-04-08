package com.michaelmark.bankingapi.services;

import com.michaelmark.bankingapi.model.Customer;

import java.util.List;

public interface CustomerService {
    void createCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    void updateCustomer(Long id, Customer customer);
    void deleteCustomer(Long id);
}
