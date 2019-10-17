package com.fedex.ground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ground.fedex.LocationDetailsRequest;
import com.ground.fedex.LocationDetailsResponse;


@SpringBootApplication
public class SpringBootSoapClientApplication {
	
	
  
    
	  public static void main(String[] args) {
	        SpringApplication.run(SpringBootSoapClientApplication.class, args);
	        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringBootSoapClientApplication.class);
	        SOAPConnector  soapConnector=context.getBean(SOAPConnector.class);;
			  LocationDetailsRequest request = new LocationDetailsRequest();
	          request.setLocationId(10);;
	          LocationDetailsResponse response =(LocationDetailsResponse) soapConnector.callWebService("http://localhost:9000/service/location-details", request);
	          System.out.println("Got Response As below ========= : ");
	          System.out.println("Door Id : "+response.getLocation().getDoorId());
	          System.out.println("Door Type : "+response.getLocation().getDoorType());
	    }
	 
	     
	   
}
