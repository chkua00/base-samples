package com.example.server.service;

import com.example.server.model.Weather;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.server.repository.WeatherRepository;

@Service
public class WeatherService {

    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);

    @Autowired
    private WeatherRepository repository;

    public List<Weather> getForecast() {
        return repository.findAll();
    }

}
