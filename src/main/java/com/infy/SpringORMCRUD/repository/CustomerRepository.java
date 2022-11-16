package com.infy.SpringORMCRUD.repository;

import com.infy.SpringORMCRUD.dto.CustomerDTO;
import com.infy.SpringORMCRUD.exception.InfyBankException;

public interface CustomerRepository {
    public CustomerDTO getCustomer(Integer customerId);

    // Create Operation using JPA with Spring Boot
    // add addCustomer() method to CustomerRepository interface
    public void addCustomer(CustomerDTO customerDTO);

    // Update Operation using JPA with Spring Boot
    // add updateCustomer() method to CustomerRepository interface
    public Integer updateCustomer(Integer customerId, String emailId);

}
