package com.infy.SpringORMCRUD;

import com.infy.SpringORMCRUD.dto.CustomerDTO;
import com.infy.SpringORMCRUD.dto.CustomerType;
import com.infy.SpringORMCRUD.exception.InfyBankException;
import com.infy.SpringORMCRUD.service.CustomerServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.time.LocalDate;

@SpringBootApplication
public class SpringORMCRUDApplication implements CommandLineRunner {
	public static final Log LOGGER = LogFactory.getLog(SpringORMCRUDApplication.class);
	@Autowired
	CustomerServiceImpl customerService;

	@Autowired
	Environment environment;
	public static void main(String[] args) {
		SpringApplication.run(SpringORMCRUDApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//getCustomer();

		// Create Operation using JPA with Spring Boot
		// add addCustomer() method
		//addCustomer();

		// Update Operation using JPA with Spring Boot
		// add updateCustomer() method
		updateCustomer();
	}

	public void getCustomer() throws InfyBankException{
		try {
			CustomerDTO customerDTO = customerService.getCustomer(1);
			LOGGER.info(customerDTO);
		} catch (Exception e){
			if(e.getMessage() != null){
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."
				));
			}
		}

	}


	// Create Operation using JPA with Spring Boot
	// add addCustomer() method to CustomerService interface
	public void addCustomer(){
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(4);
		customerDTO.setEmailId("maryam@infy.com");
		customerDTO.setName("maryam");
		customerDTO.setDateOfBirth(LocalDate.of(1994, 07, 22));
		customerDTO.setCustomerType(CustomerType.SILVER);

		try{
			customerService.addCustomer(customerDTO);
			LOGGER.info(environment.getProperty("UserInterface.INSERT_SUCCESS"));
		} catch (Exception e){
			LOGGER.info(environment.getProperty(e.getMessage(),
					"Something went wrong. Please check log file for more details."));
		}
	}


	// Update Operation using JPA with Spring Boot
	// add updateCustomer() method t
	public void updateCustomer(){
		try {
			customerService.updateCustomer(1, "buhari2022@infy.com");
			LOGGER.info(environment.getProperty("UserInterface.UPDATE_SUCCESS"));
		}catch (Exception e){
			LOGGER.info(environment.getProperty(e.getMessage(),
					"Something went wrong. Please check log file for more details."));

		}
	}
}
