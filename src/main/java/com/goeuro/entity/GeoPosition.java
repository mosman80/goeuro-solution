
package com.goeuro.entity;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author moosman
 * 
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"latitude", "longitude"})
public class GeoPosition implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("latitude")
	public double latitude;

	@JsonProperty("longitude")
	public double longitude;
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public boolean equals(Object o) {
        if (o instanceof GeoPosition) {
        	GeoPosition other = (GeoPosition) o;
            return  Objects.equals(getLatitude(), other.getLatitude()) && Objects.equals(getLongitude(), other.getLongitude());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLatitude(),getLongitude());
    }
	
	@Override
	public String toString() {
		return "GeoPosition [Latitude=" + latitude + ", Longitude=" + longitude + "]";
	}
}

