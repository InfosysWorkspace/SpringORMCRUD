package com.infy.SpringORMCRUD.repository;

import com.infy.SpringORMCRUD.dto.CustomerDTO;

public interface CustomerRepository {
    public CustomerDTO getCustomer(Integer customerId);
}
