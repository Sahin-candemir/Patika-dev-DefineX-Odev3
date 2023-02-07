package com.patikadev.weatherapi.dto;

public class WeatherRequest {

	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public WeatherRequest(String city) {
		super();
		this.city = city;
	}

	public WeatherRequest() {
		super();
	}
	
}
