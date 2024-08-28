package net.ahmed.customer_service.repository;

import net.ahmed.customer_service.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepo extends JpaRepository<Customer,Long> {
}
