package com.fedex.ground;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SpringBootSOAPApplication {
	 private static final Logger logger = LogManager.getLogger(SpringBootSOAPApplication.class);
	public static void main(String[] args) {
		logger.info("Hello ***************");
		logger.debug("Hello ***************");
		logger.error("Hello ***************");
		SpringApplication.run(SpringBootSOAPApplication.class,args);
	}

}
