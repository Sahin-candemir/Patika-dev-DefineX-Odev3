package com.patikadev.weatherapi.dto;

public class Data {

	private Weather weather;

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public Data(Weather weather) {
		super();
		this.weather = weather;
	}

	public Data() {
		super();
	}
}
