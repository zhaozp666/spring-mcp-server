package com.example.demo.mapper;

import com.example.demo.entity.Weather;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WeatherMapper {

    Weather getWeather(String city);
}
