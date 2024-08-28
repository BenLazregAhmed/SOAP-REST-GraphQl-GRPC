package net.ahmed.account_service.feign;

import net.ahmed.account_service.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8090",value = "customerRestClient")
public interface CustomerRestClient {
    @GetMapping(path = "/customers")
    List<Customer>customers();

    @GetMapping(path = "/customers/{id}")
    Customer customerById(@PathVariable(name = "id")Long id);
}
