package com.sosorry.location;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.sosorry.config.AppPropertiesLoader;

public class LocationTest {
	
	
	public void locationTest() throws Exception
	{
		
		GeoApiContext context = new GeoApiContext().setApiKey( AppPropertiesLoader.getInstance().getConfigs().get("shoutservice.google.map.apikey").toString());
		//GeocodingApi.reverseGeocode(context, location)
		GeocodingResult[] results =  GeocodingApi.geocode(context, "Sikanderpur Rapid Metro Station").await();
		System.out.println(results[0].formattedAddress);
		System.out.println(results[0].geometry.location.lat);
		System.out.println(results[0].geometry.location.lng);
		
		System.out.println("distance from mg road - "+getCorDistance(28.479529, 77.080130, results[0].geometry.location.lat, results[0].geometry.location.lng));
		
		
		
	}

	
	public static double getCorDistance(double lat1, double lon1, double lat2, double lon2)
	{
		    return 6371 * Math.acos(
		        Math.sin(lat1) * Math.sin(lat2)
		        + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1));
		
	}
}
