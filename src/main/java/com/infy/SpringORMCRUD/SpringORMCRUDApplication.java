package com.infy.SpringORMCRUD;

import com.infy.SpringORMCRUD.dto.CustomerDTO;
import com.infy.SpringORMCRUD.exception.InfyBankException;
import com.infy.SpringORMCRUD.service.CustomerServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

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
		getCustomer();
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
}
