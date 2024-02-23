package com.designCenter.designCenter.repository;

import com.designCenter.designCenter.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value = "SELECT c FROM Customer c WHERE c.nic=?1")
    Customer findCustomerByNic(String nic);
}
