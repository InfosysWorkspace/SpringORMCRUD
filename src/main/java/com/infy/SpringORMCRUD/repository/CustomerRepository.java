package com.infy.SpringORMCRUD.repository;

import com.infy.SpringORMCRUD.dto.CustomerDTO;

public interface CustomerRepository {
    public CustomerDTO getCustomer(Integer customerId);

    // Create Operation using JPA with Spring Boot
    // add addCustomer() method to CustomerRepository interface
    public void addCustomer(CustomerDTO customerDTO);
}
