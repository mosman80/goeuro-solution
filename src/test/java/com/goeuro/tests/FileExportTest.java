package com.goeuro.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.goeuro.entity.City;
import com.goeuro.entity.GeoPosition;
import com.goeuro.utils.ApplicationException;
import com.goeuro.utils.ConfigurationUtil;
import com.goeuro.utils.ExportFile;

public class FileExportTest {
	
	private static String GENERATED_FILE_PROPERTY="generated.file";
	private static String FILE_NAME = "Cairo.csv";
	List<City> expectedCityList = new ArrayList<City>();	
	String cityName = "Cairo";
	String filePath = ConfigurationUtil.getInstance().getWsProperty(GENERATED_FILE_PROPERTY);
	
	@Before
	public void setup() throws Exception {
		
		//Delete the file "Cairo.csv" if exists before exporting it
		File generatedFile = new File(filePath+FILE_NAME);
		if(generatedFile.exists()){
			generatedFile.delete();
		}
		// Compose a List of data to be exported on the file
		
		//City1
		City city1=new City();
		city1.setId("387820");
		city1.setName("Cairo Montenotte");
		city1.setType("location");
		GeoPosition geoPosition1 = new GeoPosition();
		geoPosition1.setLatitude(44.40314);
		geoPosition1.setLongitude(8.27455);		
		city1.setGeoPosition(geoPosition1);
		expectedCityList.add(city1);
		
		//City2
		City city2=new City();
		city2.setId("439390");
		city2.setName("Cairon");
		city2.setType("location");
		GeoPosition geoPosition2 = new GeoPosition();
		geoPosition2.setLatitude(49.24017);;
		geoPosition2.setLongitude(-0.45046);		
		city2.setGeoPosition(geoPosition2);
		expectedCityList.add(city2);
		
		//City3
		City city3=new City();
		city3.setId("446633");
		city3.setName("Gropello Cairoli");
		city3.setType("location");
		GeoPosition geoPosition3 = new GeoPosition();
		geoPosition3.setLatitude(45.17856);;
		geoPosition3.setLongitude(8.99275);		
		city3.setGeoPosition(geoPosition3);
		expectedCityList.add(city3);
		
		//City4
		City city4=new City();
		city4.setId("445551");
		city4.setName("Pieve del Cairo");
		city4.setType("location");
		GeoPosition geoPosition4 = new GeoPosition();
		geoPosition4.setLatitude(45.04996);;
		geoPosition4.setLongitude(8.80415);		
		city4.setGeoPosition(geoPosition4);
		expectedCityList.add(city4);
		
		//City5
		City city5=new City();
		city5.setId("314931");
		city5.setName("Cairo");
		city5.setType("airport");
		GeoPosition geoPosition5 = new GeoPosition();
		geoPosition5.setLatitude(30.11139);;
		geoPosition5.setLongitude(31.41389);		
		city5.setGeoPosition(geoPosition5);
		expectedCityList.add(city5);
	}
	
	@Test
	public void testExportFile() throws IOException, ApplicationException {		
		// generate the file 
		boolean exported = new ExportFile().exportCSVFile(cityName, expectedCityList ,City.class);
		assertTrue(exported);
		File generatedFile = new File(filePath+FILE_NAME);
		
		CsvMapper mapper = new CsvMapper();
		mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);		
		MappingIterator<String[]> it = mapper.reader(String[].class).readValues(generatedFile);
		List<City> actualCityList = new ArrayList<City>();
		it.next();// for bypass the header
		
		// Create the List manulay instead of Reading the CSV file in a List<City> to be sure that all fields are ok 
		while (it.hasNext()) {
			City city = new City();
			GeoPosition geoPostion = new GeoPosition();
			String[] row =  it.next();
		    city.setId(row[0]);
		    city.setName(row[1]);
		    city.setType(row[2]);
		    geoPostion.setLatitude(Double.parseDouble(row[3]));
		    geoPostion.setLongitude(Double.parseDouble(row[4]));
		    city.setGeoPosition(geoPostion);
		    actualCityList.add(city);
		}		
		assertEquals(expectedCityList, actualCityList);
		it.close();
	}

	//tearDown used to close the connection or clean up activities
	   public void tearDown(  ) throws IOException {
		   
	   }
}
