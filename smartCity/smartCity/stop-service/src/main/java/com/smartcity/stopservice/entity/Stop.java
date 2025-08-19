package com.smartcity.stopservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stop")
public class Stop {

    @Id
    private String id;
    private String name;
    private double lat;
    private double lon;
    private String code;
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
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}


}
