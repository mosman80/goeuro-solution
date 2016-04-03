package com.goeuro.message;

import java.util.List;

import com.goeuro.entity.City;

/**
 * @author moosman
 *
 */

public class CityResponse {
	private List<City> cityList;

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
	
	@Override
	public String toString() {
		return "CityResponse [CityList=" + cityList + "]";
	}
}
