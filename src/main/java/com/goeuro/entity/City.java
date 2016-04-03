package com.goeuro.entity;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * @author moosman 
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"id", "name","type","geo_position"}) // _id, name, type, latitude, longitude
public class City implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	@JsonProperty("_id")
	public String id;
	public String name;
	public String type;		
	public GeoPosition geoPosition;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@JsonGetter("geo_position")	
	@JsonUnwrapped(enabled=true)
	public GeoPosition getGeoPosition() {
		return geoPosition;
	}
	
	@JsonSetter("geo_position")
	@JsonUnwrapped(enabled=false)
	public void setGeoPosition(GeoPosition geoPosition) {
		this.geoPosition = geoPosition;
	}
	
	@Override
	public boolean equals(Object o) {
        if (o instanceof City) {
        	City other = (City) o;
            return  Objects.equals(getId(), other.getId()) && Objects.equals(getName(), other.getName()) 
            		&& Objects.equals(getType(), other.getType()) && Objects.equals(getGeoPosition(), other.getGeoPosition());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(),getType(),getGeoPosition());
    }
	
	
	@Override
	public String toString() {
		return "City [Id=" + id + ", Name=" + name + ", Type=" + type +", GeoPosition=" + geoPosition +"]";
	}
}
