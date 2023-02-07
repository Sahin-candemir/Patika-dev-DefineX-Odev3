package com.patikadev.weatherapi.dto;

public class WeatherResponse {
 
	private Data data;

	public WeatherResponse(Data data) {
		super();
		this.setData(data);
	}

	public WeatherResponse() {
		super();
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

}
