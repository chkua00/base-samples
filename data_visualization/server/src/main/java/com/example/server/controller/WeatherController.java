package com.example.server.controller;

import com.example.server.model.Weather;
import com.example.server.service.WeatherService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private static final Logger log = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather/find-all")
    public List<Weather> getWeather() {
        return weatherService.getForecast();
    }

}
