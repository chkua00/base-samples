package com.example.client.service;

import com.example.client.model.PriceBar;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PriceBarService {

    private static final Logger log = LoggerFactory.getLogger(PriceBarService.class);

    public List<PriceBar> getPriceBar() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/price/find-all";
        ResponseEntity<PriceBar[]> response = restTemplate.getForEntity(url, PriceBar[].class);
        PriceBar[] arrays = response.getBody();
        List<PriceBar> bars = Arrays.asList(arrays);
        return bars;
    }

}
