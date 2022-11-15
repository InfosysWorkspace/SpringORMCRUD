package com.infy.SpringORMCRUD.service;

import com.infy.SpringORMCRUD.dto.CustomerDTO;
import com.infy.SpringORMCRUD.exception.InfyBankException;

public interface CustomerService {

    public CustomerDTO getCustomer(Integer customerId) throws InfyBankException;
}
