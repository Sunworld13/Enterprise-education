package org.example.service;

import org.example.entity.Customer;
import org.example.repository.CustomerRepository;
import org.example.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{


    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }
    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Customera net"));
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Customer update(Long id, Customer updatedCustomer) {
        Customer existing = getById(id);
        existing.setFirstName(updatedCustomer.getFirstName());
        existing.setLastName(updatedCustomer.getLastName());
        existing.setEmail(updatedCustomer.getEmail());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
