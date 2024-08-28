package net.ahmed.customer_service.web;


import lombok.AllArgsConstructor;
import net.ahmed.customer_service.entity.Customer;
import net.ahmed.customer_service.repository.CustomersRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomersRestController {
    CustomersRepo customersRepo;

    @GetMapping(path = "/customers")
    public List<Customer>customersList()
    {
        return customersRepo.findAll();
    }
    @GetMapping(path = "/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id)
    {
        return customersRepo.findById(id).orElse(null);
    }
}
