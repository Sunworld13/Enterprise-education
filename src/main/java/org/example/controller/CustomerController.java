package org.example.controller;

import org.example.entity.Customer;
import org.example.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return service.create(customer);
    }

    // READ ALL
    @GetMapping
    public List<Customer> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id,
                           @RequestBody Customer customer) {
        return service.update(id, customer);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
