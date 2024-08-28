package net.ahmed.customer_service.web;

import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.ahmed.customer_service.entity.Customer;
import net.ahmed.customer_service.mappers.CustomerMapper;
import net.ahmed.customer_service.repository.CustomersRepo;
import net.ahmed.customer_service.stub.CustomerServiceGrpc;
import net.ahmed.customer_service.stub.CustomerServiceOuterClass;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;
import java.util.List;

@GrpcService
@AllArgsConstructor
public class CustomerGrpcService extends CustomerServiceGrpc.CustomerServiceImplBase {
    private CustomersRepo customersRepo;
    private CustomerMapper mapper;
    @Override
    public void getAllCustomers(CustomerServiceOuterClass.GetAllCustomersRequest request, StreamObserver<CustomerServiceOuterClass.GetAllCustomersResponse> responseObserver) {
        List<Customer>customers=customersRepo.findAll();
        List<CustomerServiceOuterClass.Customer>customerList=customers.stream().map(
                (c)-> {
                    return mapper.fromCustomer(c);
                }
        ).toList();
        CustomerServiceOuterClass.GetAllCustomersResponse getAllCustomersResponse= CustomerServiceOuterClass
                .GetAllCustomersResponse.newBuilder()
                .addAllCustomers(customerList)
                .build();
        responseObserver.onNext(getAllCustomersResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getCustomerById(CustomerServiceOuterClass.GetCustomerByIdRequest request, StreamObserver<CustomerServiceOuterClass.GetCustomerByIdResponse> responseObserver) {
        Customer customer=customersRepo.findById(request.getId()).orElse(null);
        CustomerServiceOuterClass.GetCustomerByIdResponse customerByIdResponse= CustomerServiceOuterClass
                .GetCustomerByIdResponse.newBuilder()
                .setCustomer(mapper.fromCustomer(customer))
                .build();
        responseObserver.onNext(customerByIdResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void saveCustomer(CustomerServiceOuterClass.SaveCustomerRequest request, StreamObserver<CustomerServiceOuterClass.SaveCustomerResponse> responseObserver) {
        Customer customer=mapper.fromGrpcCustomerRequest(request.getCustomer());
        customer=customersRepo.save(customer);
        CustomerServiceOuterClass.SaveCustomerResponse saveCustomerResponse= CustomerServiceOuterClass
                .SaveCustomerResponse.newBuilder()
                .setCustomer(mapper.fromCustomer(customer))
                .build();
        responseObserver.onNext(saveCustomerResponse);
        responseObserver.onCompleted();

    }
}
