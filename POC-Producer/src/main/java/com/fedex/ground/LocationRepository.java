package com.fedex.ground;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.locationsoap.xml.location.Location;



@Component
public class LocationRepository {
	private static final Map<Integer, Location> locations = new HashMap<>();
	 private static final Logger logger = LogManager.getLogger(LocationEndPoint.class);
	@PostConstruct
	public void initData() {
		
		Location location = new Location();
		location.setDoorId(5);
		location.setDoorType("LOAD");
		locations.put(location.getDoorId(), location);
		
		location = new Location();
		location.setDoorId(10);
		location.setDoorType("LOAD1");
		locations.put(location.getDoorId(), location);
		
		
	}

	public Location findLocation(int locationId,String locationType) {
		Assert.notNull(locationId, "The location's name must not be null");
		Location location=null;
		try{
			location=locations.get(locationId);
		}catch(SOAPFaultException e){
			logger.error("No Location for Id"+locationId);
		}
		catch(Exception e){
			logger.error("No Location for Id"+locationId);
		}
		return location;
	}
}