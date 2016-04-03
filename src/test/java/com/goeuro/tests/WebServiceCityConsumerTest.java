package com.goeuro.tests;


import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.goeuro.client.WebServiceCityConsumer;
import com.goeuro.entity.City;
import com.goeuro.entity.GeoPosition;
import com.goeuro.message.CityRequest;
import com.goeuro.message.CityResponse;
import com.goeuro.utils.ApplicationException;
import com.goeuro.utils.ExportFile;

public class WebServiceCityConsumerTest {
	CityRequest request = new CityRequest ();
	CityResponse response = new CityResponse();
	
	@Before
	public void setUp() throws Exception {
		
		request.setCityName("Cairo");
		List<City> cityList = new ArrayList<City>();
			
//		{"_id":387820,"key":null,"name":"Cairo Montenotte","fullName":"Cairo Montenotte, Italy","iata_airport_code":null,"type":"location","country":"Italy","geo_position":{"latitude":44.40314,"longitude":8.27455},"locationId":20028,"inEurope":true,"countryCode":"IT","coreCountry":true,"distance":null},
						
		//City1
		City city1=new City();
		city1.setId("387820");
		city1.setName("Cairo Montenotte");
		city1.setType("location");
		GeoPosition geoPosition1 = new GeoPosition();
//		"geo_position":{"latitude":44.40314,"longitude":8.27455}
		geoPosition1.setLatitude(44.40314);
		geoPosition1.setLongitude(8.27455);		
		city1.setGeoPosition(geoPosition1);
		cityList.add(city1);
//		{"_id":439390,"key":null,"name":"Cairon","fullName":"Cairon, France","iata_airport_code":null,"type":"location","country":"France","geo_position":{"latitude":49.24017,"longitude":-0.45046},"locationId":138874,"inEurope":true,"countryCode":"FR","coreCountry":true,"distance":null},
		
		//City2
		City city2=new City();
		city2.setId("439390");
		city2.setName("Cairon");
		city2.setType("location");
		GeoPosition geoPosition2 = new GeoPosition();
//		"geo_position":{"latitude":49.24017,"longitude":-0.45046}
		geoPosition2.setLatitude(49.24017);;
		geoPosition2.setLongitude(-0.45046);		
		city2.setGeoPosition(geoPosition2);
		cityList.add(city2);
		
//		{"_id":446633,"key":null,"name":"Gropello Cairoli","fullName":"Gropello Cairoli, Italy","iata_airport_code":null,"type":"location","country":"Italy","geo_position":{"latitude":45.17856,"longitude":8.99275},"locationId":146249,"inEurope":true,"countryCode":"IT","coreCountry":true,"distance":null},
		//City3
		City city3=new City();
		city3.setId("446633");
		city3.setName("Gropello Cairoli");
		city3.setType("location");
		GeoPosition geoPosition3 = new GeoPosition();
//		"geo_position":{"latitude":45.17856,"longitude":8.99275}
		geoPosition3.setLatitude(45.17856);;
		geoPosition3.setLongitude(8.99275);		
		city3.setGeoPosition(geoPosition3);
		cityList.add(city3);
		
//		{"_id":445551,"key":null,"name":"Pieve del Cairo","fullName":"Pieve del Cairo, Italy","iata_airport_code":null,"type":"location","country":"Italy","geo_position":{"latitude":45.04996,"longitude":8.80415},"locationId":145160,"inEurope":true,"countryCode":"IT","coreCountry":true,"distance":null},
		//City4
		City city4=new City();
		city4.setId("445551");
		city4.setName("Pieve del Cairo");
		city4.setType("location");
		GeoPosition geoPosition4 = new GeoPosition();
//		"geo_position":{"latitude":45.04996,"longitude":8.80415}
		geoPosition4.setLatitude(45.04996);;
		geoPosition4.setLongitude(8.80415);		
		city4.setGeoPosition(geoPosition4);
		cityList.add(city4);
		
//		{"_id":314931,"key":null,"name":"Cairo","fullName":"Cairo (CAI), Egypt","iata_airport_code":"CAI","type":"airport","country":"Egypt","geo_position":{"latitude":30.11139,"longitude":31.41389},"locationId":null,"inEurope":false,"countryCode":"EG","coreCountry":false,"distance":null}]
		//City5
		City city5=new City();
		city5.setId("314931");
		city5.setName("Cairo");
		city5.setType("airport");
		GeoPosition geoPosition5 = new GeoPosition();
//		"geo_position":{"latitude":30.11139,"longitude":31.41389}
		geoPosition5.setLatitude(30.11139);;
		geoPosition5.setLongitude(31.41389);		
		city5.setGeoPosition(geoPosition5);
		cityList.add(city5);
		
		response.setCityList(cityList);
		
	}

	@Test
	public void testCityDetailsByName() throws ApplicationException {
		WebServiceCityConsumer webServiceTest = new WebServiceCityConsumer();
		CityResponse res = webServiceTest.getCityDetailsByName(request);
		assertEquals(res.getCityList(),response.getCityList());
	}

	//tearDown used to close the connection or clean up activities
   public void tearDown(  ) {
	   
   }
   
}
