/**
 * 
 */
package com.goeuro.main;

import org.apache.log4j.Logger;

import com.goeuro.client.WebServiceCityConsumer;
import com.goeuro.entity.City;
import com.goeuro.message.CityRequest;
import com.goeuro.message.CityResponse;
import com.goeuro.utils.ConfigurationUtil;
import com.goeuro.utils.ExportFile;

/**
 * @author moosman
 *
 */
public class GoEuroTestMain {

	public static Logger logger = Logger.getLogger(GoEuroTestMain.class);

	public GoEuroTestMain() {
		ConfigurationUtil.getInstance().loadLog4jConfigurations();
	}

	public static void main(String[] args) {
		new GoEuroTestMain();
		Logger logger = Logger.getLogger(GoEuroTestMain.class);
		try{
			if (args.length != 1) {
				logger.error("Bad Arrguments");			
			}
			String cityName = args[0];
			logger.info("Passed Param :" + cityName);
			CityRequest cityRequest = new CityRequest();
			cityRequest.setCityName(cityName);
			logger.info("[Request: " + cityRequest + "] ");
			CityResponse response = new WebServiceCityConsumer().getCityDetailsByName(cityRequest);
			logger.info("[Response: " + response + "] ");
			boolean exported = new ExportFile().exportCSVFile(cityName, response.getCityList(),City.class);			
			if(exported){
				logger.info("File Exported Successfully");
			}else{
				logger.error("Problem occure while exporting the csv file");
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
		}

	}

}
