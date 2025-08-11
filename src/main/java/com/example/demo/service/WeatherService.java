package com.example.demo.service;

import com.example.demo.entity.Weather;
import com.example.demo.mapper.WeatherMapper;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WeatherService {

    private final WeatherMapper weatherMapper;
    public WeatherService(WeatherMapper weatherMapper) {
        this.weatherMapper = weatherMapper;
    }

    private static final Map<String, String> WEATHER_MAP = Map.of(
            "上海", "晴天",
            "北京", "多云",
            "成都", "下雨"
    );

    @Tool(description = "根据城市获取天气")
    public String getWeather(@ToolParam(description = "城市") String city) {
        // Implement weather service logic
        //return WEATHER_MAP.getOrDefault(city, "未知");

        Weather weather = weatherMapper.getWeather(city);
        return weather.toString();
    }
}
