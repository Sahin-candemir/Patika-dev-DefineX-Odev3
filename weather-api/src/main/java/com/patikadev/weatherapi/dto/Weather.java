package com.patikadev.weatherapi.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2564314102918801882L;
	private String description;
    private BigDecimal temperature;
    private BigDecimal feelsLike;
    private BigDecimal windSpeed;
	public Weather(String description, BigDecimal temperature, BigDecimal feelsLike, BigDecimal windSpeed) {
		super();
		this.setDescription(description);
		this.setTemperature(temperature);
		this.setFeelsLike(feelsLike);
		this.setWindSpeed(windSpeed);
	}
	public Weather() {
		super();
	}
	public BigDecimal getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(BigDecimal windSpeed) {
		this.windSpeed = windSpeed;
	}
	public BigDecimal getFeelsLike() {
		return feelsLike;
	}
	public void setFeelsLike(BigDecimal feelsLike) {
		this.feelsLike = feelsLike;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getTemperature() {
		return temperature;
	}
	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}
	
	
}
