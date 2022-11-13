package com.incubateur.localibjava.service;

import com.incubateur.localibjava.model.Customer;
import com.incubateur.localibjava.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService {


    private final CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomer() {
        return (List<Customer>) customerRepository.findAll();
    }

    public String deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
        return "Customer remove";
    }


    public Customer updateCustomerById(Long id, Customer customer) {
        return customerRepository.findById(id)
                .map(c-> {
            c.setFirstName(customer.getFirstName());
            c.setLastName(customer.getLastName());
            c.setBirthday(customer.getBirthday());
            c.setEmail(customer.getEmail());
            c.setPhone(customer.getPhone());
            return customerRepository.save(c);
        }).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

}
