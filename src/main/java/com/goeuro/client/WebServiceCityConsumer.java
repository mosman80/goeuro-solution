package com.goeuro.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.goeuro.entity.City;
import com.goeuro.main.GoEuroTestMain;
import com.goeuro.message.CityRequest;
import com.goeuro.message.CityResponse;
import com.goeuro.utils.ApplicationException;
import com.goeuro.utils.ConfigurationUtil;

/**
 * @author moosman
 *
 */

public class WebServiceCityConsumer {

	private WebTarget webTarget;
	private Client client;
	private static final String BASE_URI = "server.url";
	private static final String SERVICE_ENDPOINT = "city.endpoint";

	final static Logger logger = Logger.getLogger(GoEuroTestMain.class);

	public WebServiceCityConsumer() {
		ConfigurationUtil configUtil = ConfigurationUtil.getInstance();
		String serverUrl = configUtil.getWsProperty(BASE_URI);
		String serviceEndPoint = configUtil.getWsProperty(SERVICE_ENDPOINT);
		client = ClientBuilder.newClient();
		webTarget = client.target(serverUrl).path(serviceEndPoint);
	}

	public CityResponse getCityDetailsByName(CityRequest request) throws ApplicationException {
		
		CityResponse cityResponse = new CityResponse();
		try{
			WebTarget resourceWebTarget = webTarget.path(request.getCityName());
			Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_JSON_TYPE);
			Response response = invocationBuilder.get();
			logger.info("Response : "+response);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
	
			List<City> cityList = response.readEntity(new GenericType<List<City>>() {});
//			logger.info("Response: " + cityList);
			cityResponse.setCityList(cityList);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		return cityResponse;
	}

	// Can add more service operation her Ex: getCityByKey, addCity, getAll, deleteCity, ...etc

	public void close() {
		client.close();
	}
}
