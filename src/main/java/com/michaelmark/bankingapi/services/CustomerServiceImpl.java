package com.michaelmark.bankingapi.services;

import com.michaelmark.bankingapi.model.Customer;
import com.michaelmark.bankingapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public void updateCustomer(Long id, Customer customer) {
        Customer savedCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer with id: " + id + "not found"));
        savedCustomer.setFirstName(customer.getFirstName());
        savedCustomer.setLastName(customer.getLastName());
        savedCustomer.setEmail(customer.getEmail());
        savedCustomer.setPhoneNumber(customer.getPhoneNumber());
        customerRepository.save(savedCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customerRepository.delete(customer);
    }
}
