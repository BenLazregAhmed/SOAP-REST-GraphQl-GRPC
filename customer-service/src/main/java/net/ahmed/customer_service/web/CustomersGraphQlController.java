package net.ahmed.customer_service.web;

import lombok.AllArgsConstructor;
import net.ahmed.customer_service.Dto.CustomerReq;
import net.ahmed.customer_service.entity.Customer;
import net.ahmed.customer_service.mappers.CustomerMapper;
import net.ahmed.customer_service.repository.CustomersRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomersGraphQlController {
    CustomersRepo customersRepo;
    CustomerMapper customerMapper;

    @QueryMapping
    public List<Customer> customersList()
    {
        return customersRepo.findAll();
    }
    @QueryMapping
    public Customer customerById(@Argument Long id)
    {
        return customersRepo.findById(id).orElseThrow(()->new RuntimeException("Customers Not Found !!"));
    }
    @MutationMapping
    public Customer saveCustomer(@Argument(name = "customer") CustomerReq customerReq)
    {
        Customer customer=customerMapper.fromCustomerReq(customerReq);
        return customersRepo.save(customer);
    }
    }