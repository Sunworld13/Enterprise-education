package org.example.service;

import org.example.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface  CustomerService {
    Customer create  (Customer customer);
    Customer getById (Long id);
    List<Customer> getAll ();
    Customer update (Long id, Customer customer);
    void delete (Long id);
}
