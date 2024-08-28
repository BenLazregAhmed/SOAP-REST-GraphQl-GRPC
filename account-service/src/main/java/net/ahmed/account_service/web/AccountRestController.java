package net.ahmed.account_service.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.ahmed.account_service.feign.CustomerRestClient;
import net.ahmed.account_service.mappers.CustomerMapper;
import net.ahmed.account_service.model.Customer;
import net.ahmed.customer_service.stub.CustomerServiceGrpc;
import net.ahmed.customer_service.stub.CustomerServiceOuterClass;
import net.ahmed.customer_service.web.CustomerSoapService;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/accountService")
public class AccountRestController {
    RestTemplate restTemplate;
    CustomerRestClient customerRestClient;
    CustomerSoapService customerSoapService;
    CustomerMapper customerMapper;
    @GrpcClient(value = "customerService")
    CustomerServiceGrpc.CustomerServiceBlockingStub customerServiceBlockingStub;

    public AccountRestController(RestTemplate restTemplate, CustomerRestClient customerRestClient, CustomerSoapService customerSoapService, CustomerMapper customerMapper) {
        this.restTemplate = restTemplate;
        this.customerRestClient = customerRestClient;
        this.customerSoapService = customerSoapService;
        this.customerMapper = customerMapper;
    }

    //RestClients
    @GetMapping(path = "/customers/v2")
    public Flux<Customer>customerFlux()
    {
        //methode non bloquante
        WebClient webClient= WebClient.builder()
                .baseUrl("http://localhost:8090")
                .build();
        return webClient.get().uri("/customers").retrieve().bodyToFlux(Customer.class);

    }

    @GetMapping(path = "/customers")
    public List<Customer> customers()
    {
        //methode bloquante
        Customer[] customers = restTemplate.getForObject("http://localhost:8090/customers", Customer[].class);
        if(customers==null)
            return null;
        return Arrays.stream(customers).toList();
    }
    @GetMapping(path = "/customers/v3")

    public List<Customer> customersFeign(){
        return customerRestClient.customers();
    }

    @GetMapping(path = "/customer/{id}")
    public Customer customerById(@PathVariable(name = "id") Long id)
    {
        return restTemplate.getForObject("http://localhost:8090/customers/"+id, Customer.class);
    }

    @GetMapping(path = "/customers/v2/{id}")
    public Mono<Customer> customerMono(@PathVariable(name = "id") Long id)
    {
        //methode non bloquante
        WebClient webClient= WebClient.builder()
                .baseUrl("http://localhost:8090")
                .build();
        return webClient.get().uri("/customers/{id}",id).retrieve().bodyToMono(Customer.class);

    }
    @GetMapping(path = "/customers/v3/{id}")

    public Customer customersFeign(@PathVariable(name = "id") Long id){
        return customerRestClient.customerById(id);
    }

    @GetMapping(path = "/gql/customers")
    public Mono<List<Customer>> customersGraphQl()
    {
        HttpGraphQlClient graphQlClient=HttpGraphQlClient.builder()
                .url("http://localhost:8090/graphql")
                .build();
        var httpRequestDocument= """
                 query {
                     customersList{
                        id,firstName,lastName,email
                     }
                   }
                """;
        return graphQlClient.document(httpRequestDocument)
                .retrieve("customersList")
                .toEntityList(Customer.class);
    }
//GraphQlClient
    @GetMapping(path = "/gql/customer/{id}")
    public Mono<Customer> customerByIdGraphQl(@PathVariable(name = "id") Long id)
    {
        HttpGraphQlClient httpGraphQlClient= HttpGraphQlClient.builder()
                .url("http://localhost:8090/graphql")
                .build();
        var httpRequestDocument= """
                 query($id:Int) {
                    customerById(id:$id){
                      id, firstName, email
                    }
                  }
                """;
        return httpGraphQlClient.document(httpRequestDocument)
                .variable("id",id)
                .retrieve("customerById")
                .toEntity(Customer.class);
    }
    //SOAP client

    @GetMapping(path = "/soap/customers")
    public List<Customer>soapCustomers()
    {
        List<net.ahmed.customer_service.web.Customer> soapCustomers=customerSoapService.customersList();
        return soapCustomers.stream().map(
                (c) -> customerMapper.fromSoapCustomer(c)
        ).toList();
    }

    @GetMapping(path = "/soap/customers/{id}")
    public  Customer soapCustomerById(@PathVariable(name = "id")Long id)
    {
        net.ahmed.customer_service.web.Customer customer=customerSoapService.getCustomerById(id);
        return customerMapper.fromSoapCustomer(customer);
    }

    //GRPC client
    @GetMapping(path = "/grpc/customers")
    public List<Customer>grpcCustomers()
    {
        CustomerServiceOuterClass.GetAllCustomersRequest getAllCustomersRequest= CustomerServiceOuterClass.GetAllCustomersRequest.newBuilder()
                .build();
        CustomerServiceOuterClass.GetAllCustomersResponse response = customerServiceBlockingStub.getAllCustomers(getAllCustomersRequest);
        return response.getCustomersList().stream().map(
                c->customerMapper.fromGrpcCustomer(c)
        ).toList();
    }

    @GetMapping(path = "/grpc/customers/{id}")
    public  Customer grpcCustomerById(@PathVariable(name = "id")Long id)
    {
        CustomerServiceOuterClass.GetCustomerByIdRequest getCustomerByIdRequest= CustomerServiceOuterClass.GetCustomerByIdRequest.newBuilder()
                .setId(id)
                .build();
        CustomerServiceOuterClass.GetCustomerByIdResponse response = customerServiceBlockingStub.getCustomerById(getCustomerByIdRequest);
        return customerMapper.fromGrpcCustomer(response.getCustomer());
    }
}
