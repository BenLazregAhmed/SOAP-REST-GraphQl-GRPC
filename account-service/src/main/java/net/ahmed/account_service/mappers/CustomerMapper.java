package net.ahmed.account_service.mappers;

import net.ahmed.account_service.model.Customer;
import net.ahmed.customer_service.stub.CustomerServiceOuterClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private final ModelMapper mapper=new ModelMapper();
    public Customer fromSoapCustomer(net.ahmed.customer_service.web.Customer soapCustomer)
    {
        return mapper.map(soapCustomer, Customer.class);
    }
    public Customer fromGrpcCustomer(CustomerServiceOuterClass.Customer grpcCustomer){
        return mapper.map(grpcCustomer, Customer.class);
    }
}
