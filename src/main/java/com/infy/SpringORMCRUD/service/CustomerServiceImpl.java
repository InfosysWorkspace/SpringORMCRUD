package com.infy.SpringORMCRUD.service;


import com.infy.SpringORMCRUD.dto.CustomerDTO;
import com.infy.SpringORMCRUD.exception.InfyBankException;
import com.infy.SpringORMCRUD.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service(value = "customerService")
public class CustomerServiceImpl {

    @Autowired
    private CustomerRepository customerRepository;
    public CustomerDTO getCustomer(Integer customerId) throws InfyBankException{
        CustomerDTO customerDTO = customerRepository.getCustomer(customerId);
        if(customerDTO == null){
            throw new InfyBankException("Service.CUSTOMER_UNAVAILABLE");
        }

        return customerDTO;
    }
}
