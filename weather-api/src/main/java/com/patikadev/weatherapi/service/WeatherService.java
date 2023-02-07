package com.patikadev.weatherapi.service;

import java.math.BigDecimal;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patikadev.weatherapi.dto.Weather;
import com.patikadev.weatherapi.dto.WeatherRequest;

@Service
public class WeatherService {

	
	private final ObjectMapper objectMapper;
	public WeatherService( ObjectMapper objectMapper) {
		super();
		this.objectMapper = objectMapper;
	}
	public Weather currentWeather(WeatherRequest weatherRequest) throws JsonMappingException, JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.openweathermap.org/data/2.5/weather?q="+weatherRequest.getCity()+"&appid=1625ce80e9ad1585b190dff32c4c9379";
		
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,null,String.class);

		return convert(response);

	}
	private Weather convert(ResponseEntity<String> response) {
        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            return new Weather(root.path("weather").get(0).path("main").asText(),
                    BigDecimal.valueOf(root.path("main").path("temp").asDouble()),
                    BigDecimal.valueOf(root.path("main").path("feels_like").asDouble()),
                    BigDecimal.valueOf(root.path("wind").path("speed").asDouble()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }
	public Weather dailyWeather(WeatherRequest weatherRequest) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.openweathermap.org/data/2.5/forecast/daily?q="+weatherRequest.getCity()+"&cnt=1&appid=64e1039708f4b944a0a245ea672b2341";
		
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,null,String.class);

		return convert(response);
	}
	public Weather weeklyWeather(WeatherRequest weatherRequest) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.openweathermap.org/data/2.5/forecast/daily?q="+weatherRequest.getCity()+"&cnt=7&appid=64e1039708f4b944a0a245ea672b2341";
		
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,null,String.class);

		return convert(response);
	}
	public Weather monthlyWeather(WeatherRequest weatherRequest) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.openweathermap.org/data/2.5/forecast/daily?q="+weatherRequest.getCity()+"&cnt=30&appid=64e1039708f4b944a0a245ea672b2341";
		
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,null,String.class);

		return convert(response);
	}

}
