package com.patikadev.weatherapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.patikadev.weatherapi.dto.WeatherRequest;
import com.patikadev.weatherapi.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

	private final WeatherService weatherService;
	
	public WeatherController(WeatherService weatherService) {

		this.weatherService = weatherService;
	}

	@PostMapping("/current")
	public ResponseEntity<?> currentWeather(@RequestBody WeatherRequest weatherRequest) throws JsonMappingException, JsonProcessingException{
		return new ResponseEntity<>(weatherService.currentWeather(weatherRequest),HttpStatus.OK);
	}
	@PostMapping("/daily")
	public ResponseEntity<?> dailyWeather(@RequestBody WeatherRequest weatherRequest) throws JsonMappingException, JsonProcessingException{
		return new ResponseEntity<>(weatherService.dailyWeather(weatherRequest),HttpStatus.OK);
	}
	@PostMapping("/weekly")
	public ResponseEntity<?> weeklyWeather(@RequestBody WeatherRequest weatherRequest) throws JsonMappingException, JsonProcessingException{
		return new ResponseEntity<>(weatherService.weeklyWeather(weatherRequest),HttpStatus.OK);
	}
	@PostMapping("/monthly")
	public ResponseEntity<?> monthlyWeather(@RequestBody WeatherRequest weatherRequest) throws JsonMappingException, JsonProcessingException{
		return new ResponseEntity<>(weatherService.monthlyWeather(weatherRequest),HttpStatus.OK);
	}
	
}
