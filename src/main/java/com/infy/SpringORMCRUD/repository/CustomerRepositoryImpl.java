package com.infy.SpringORMCRUD.repository;


import com.infy.SpringORMCRUD.dto.CustomerDTO;
import com.infy.SpringORMCRUD.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository(value = "customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository{

    @PersistenceContext
    private EntityManager entityManager;


    // Create Operation using JPA with Spring Boot (adding just the @Override Annotation)
    @Override
    public CustomerDTO getCustomer(Integer customerId) {

        CustomerDTO customerDTO = null;
        Customer customer = entityManager.find(Customer.class, customerId);
        if(customer != null){
            customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
            customerDTO.setEmailId(customer.getEmailId());
            customerDTO.setName(customer.getName());
            customerDTO.setCustomerType(customer.getCustomerType());
        }
        return customerDTO;
    }

    // Create Operation using JPA with Spring Boot
    // add addCustomer() method to CustomerRepositoryImpl
    @Override
    public void addCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setDateOfBirth(customerDTO.getDateOfBirth());
        customer.setEmailId(customerDTO.getEmailId());
        customer.setName(customerDTO.getName());
        customer.setCustomerType(customerDTO.getCustomerType());
        // persist()
        entityManager.persist(customer);

    }

    // Update Operation using JPA with Spring Boot
    // add updateCustomer() method to CustomerRepositoryImpl
    @Override
    public Integer updateCustomer(Integer customerId, String emailId){
        Integer customerIdReturned = null;
        Customer customer = entityManager.find(Customer.class, customerId);
        customer.setEmailId(emailId);
        customerIdReturned = customer.getCustomerId();
        return customerIdReturned;
    }
}
