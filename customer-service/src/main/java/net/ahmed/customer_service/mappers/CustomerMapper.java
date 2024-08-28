package net.ahmed.customer_service.mappers;

import net.ahmed.customer_service.Dto.CustomerReq;
import net.ahmed.customer_service.entity.Customer;
import net.ahmed.customer_service.stub.CustomerServiceOuterClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private final ModelMapper modelMapper=new ModelMapper();
    public Customer fromCustomerReq(CustomerReq customerReq){
        return modelMapper.map(customerReq, Customer.class);
    }

    public CustomerServiceOuterClass.Customer fromCustomer(Customer customer){
        return modelMapper.map(customer, CustomerServiceOuterClass.Customer.Builder.class).build();
    }

    public Customer fromGrpcCustomerRequest(CustomerServiceOuterClass.CustomerRequest customerRequest)
    {
        return modelMapper.map(customerRequest, Customer.class);
    }
}
