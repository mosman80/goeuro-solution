package com.goeuro.message;

/**
 * @author moosman
 *
 */

public class CityRequest {
	
	 private String cityName;	  
//	 private Header header;
	 
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
//	public Header getHeader() {
//		return header;
//	}
//	public void setHeader(Header header) {
//		this.header = header;
//	}
	
	@Override
	public String toString() {
		return "CityRequest [CityName=" + cityName + "]";
	}

}
