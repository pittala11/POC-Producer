package com.fedex.ground;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.locationsoap.xml.location.Location;
import com.locationsoap.xml.location.LocationDetailsRequest;
import com.locationsoap.xml.location.LocationDetailsResponse;

@Endpoint
public class LocationEndPoint {
	private static final String NAMESPACE_URI = "http://www.LocationSOAP.com/xml/location";
	 private static final Logger logger = LogManager.getLogger(LocationEndPoint.class);
	private LocationRepository locationRepository;

	@Autowired
	public LocationEndPoint(LocationRepository LocationRepository) {
		this.locationRepository = LocationRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "LocationDetailsRequest")
	@ResponsePayload
	public LocationDetailsResponse getLocation(@RequestPayload LocationDetailsRequest request) {
		logger.info(" endpoint *********");
		logger.debug(" endpoint *********");
		logger.error(" endpoint *********");
		LocationDetailsResponse response = new LocationDetailsResponse();
		Location location=locationRepository.findLocation(request.getLocationId(),request.getLocationOpCoType());
		if(null!=location)
		response.setLocation(location);

		return response;
	}
}