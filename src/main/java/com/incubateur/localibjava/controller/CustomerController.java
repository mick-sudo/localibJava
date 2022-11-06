package com.incubateur.localibjava.controller;

import com.incubateur.localibjava.model.Customer;
import com.incubateur.localibjava.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping()
    public List<Customer> customerList(){
        return customerService.getAllCustomer();
    }

    @DeleteMapping("delete/{id}")
    public String deleteCustomer(@PathVariable Integer id){
       return customerService.deleteCustomerById(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Integer id,@RequestBody Customer customer){
        return customerService.updateCustomerById(id, customer);
    }
}