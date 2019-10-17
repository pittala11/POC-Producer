package com.fedex.ground;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ground.fedex.LocationDetailsRequest;
import com.ground.fedex.LocationDetailsResponse;



@Endpoint
public class LocationEndPoint {
	private static final String NAMESPACE_URI = "http://www.LocationSOAP.com/xml/location";
	 private static final Logger logger = LogManager.getLogger(LocationEndPoint.class);
	private   SOAPConnector  soapConnector;
	@Autowired
	public LocationEndPoint(SOAPConnector  soapConnector) {
		this.soapConnector = soapConnector;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "LocationDetailsRequest")
	@ResponsePayload
	public LocationDetailsResponse getLocation(@RequestPayload LocationDetailsRequest request) {
		logger.info(" endpoint *********");
		logger.debug(" endpoint *********");
		logger.error(" endpoint *********");
		//Location location=locationRepository.findLocation(request.getLocationId(),request.getLocationOpCoType());
          LocationDetailsResponse response =(LocationDetailsResponse) soapConnector.callWebService("http://localhost:9000/service/location-details", request);
          System.out.println("Got Response As below ========= : ");
          System.out.println("Door Id : "+response.getLocation().getDoorId());
          System.out.println("Door Type : "+response.getLocation().getDoorType());

		return response;
	}
}