package com.tejaitb4.springbootb4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springbootb4Application {
private static final Logger logger=LogManager.getLogger(SpringBootApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Springbootb4Application.class, args);
		logger.info("This is Teja IT..info Method");
		logger.warn("warning method");
		logger.error("error method");
		logger.debug("debug methodS");
	}

}
