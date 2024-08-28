package net.ahmed.customer_service.web;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import net.ahmed.customer_service.Dto.CustomerReq;
import net.ahmed.customer_service.entity.Customer;
import net.ahmed.customer_service.mappers.CustomerMapper;
import net.ahmed.customer_service.repository.CustomersRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@WebService(serviceName = "CustomerWS")
@AllArgsConstructor
public class CustomerSoapService {
    CustomersRepo customersRepo;
    CustomerMapper customerMapper;
    @WebMethod
    public List<Customer> customersList()
    {
        return customersRepo.findAll();
    }
    @WebMethod
    public Customer getCustomerById(@WebParam(name = "id") Long id)
    {
        return customersRepo.findById(id).orElse(null);
    }
    @WebMethod
    public Customer saveCustomer(@WebParam(name = "customer") CustomerReq customerReq)
    {
        Customer customer=customerMapper.fromCustomerReq(customerReq);
        return customersRepo.save(customer);
    }

}
