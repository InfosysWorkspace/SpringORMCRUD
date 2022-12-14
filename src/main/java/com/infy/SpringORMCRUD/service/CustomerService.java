package com.infy.SpringORMCRUD.service;

import com.infy.SpringORMCRUD.dto.CustomerDTO;
import com.infy.SpringORMCRUD.exception.InfyBankException;

public interface CustomerService {

    public CustomerDTO getCustomer(Integer customerId) throws InfyBankException;

    // Create Operation using JPA with Spring Boot
    // add addCustomer() method to CustomerService interface
    public void addCustomer(CustomerDTO customerDTO) throws InfyBankException;

    // Update Operation using JPA with Spring Boot
    // add updateCustomer() method to CustomerService interface
    public void updateCustomer(Integer customerId, String emailId) throws InfyBankException;

    // Delete Operation using JPA with Spring Boot
    // add deleteCustomer() method to CustomerService interface
    public void deleteCustomer(Integer customerId) throws InfyBankException;
}
