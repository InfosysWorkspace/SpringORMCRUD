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

	@Autowired
	CustomerServiceImpl customerService;

	@Autowired
	Environment environment;

	public static final Log LOGGER = LogFactory.getLog(SpringORMCRUDApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(SpringORMCRUDApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		getCustomer();

		// Create Operation using JPA with Spring Boot
		// add addCustomer() method
		addCustomer();
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
		customerDTO.setCustomerId(1);
		customerDTO.setEmailId("buhari@infy.com");
		customerDTO.setName("buhari");
		customerDTO.setDateOfBirth(LocalDate.of(1985, 07, 05));
		customerDTO.setCustomerType(CustomerType.GOLD);

		try{
			customerService.addCustomer(customerDTO);
			LOGGER.info(environment.getProperty("UserInterface.INSERT_SUCCESS"));
		} catch (Exception e){
			LOGGER.info(environment.getProperty(e.getMessage(),
					"Something went wrong. Please check log file for more details."));
		}
	}
}
