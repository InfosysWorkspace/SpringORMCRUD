package com.infy.SpringORMCRUD.service;


import com.infy.SpringORMCRUD.dto.CustomerDTO;
import com.infy.SpringORMCRUD.exception.InfyBankException;
import com.infy.SpringORMCRUD.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



// Create Operation using JPA with Spring Boot
// add @Transactional to create a database transaction
@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    // Create Operation using JPA with Spring Boot (Override)
    @Override
    public CustomerDTO getCustomer(Integer customerId) throws InfyBankException{
        CustomerDTO customerDTO = customerRepository.getCustomer(customerId);
        if(customerDTO == null){
            throw new InfyBankException("Service.CUSTOMER_UNAVAILABLE");
        }

        return customerDTO;
    }

    // Create Operation using JPA with Spring Boot
    // add addCustomer() method to CustomerService
    @Override
    public void addCustomer(CustomerDTO customerDTO) throws InfyBankException{
        if (customerRepository.getCustomer(customerDTO.getCustomerId()) != null){
            throw new InfyBankException("Service.CUSTOMER_ALREADY_EXISTS");
        }
        customerRepository.addCustomer(customerDTO);
    }
}
