package com.example.demo.controller;

import com.example.demo.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final WeatherService weatherService;

    public TestController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/getWeather")
    public String getWeather(String city) {
        return weatherService.getWeather(city);
    }
}
