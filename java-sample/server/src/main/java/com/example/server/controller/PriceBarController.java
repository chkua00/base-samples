package com.example.server.controller;

import com.example.server.model.PriceBar;
import com.example.server.service.PriceBarService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceBarController {

    private static final Logger log = LoggerFactory.getLogger(PriceBarController.class);

    @Autowired
    private PriceBarService priceBarService;

    @GetMapping("/price/find-all")
    public List<PriceBar> getPriceBar() {
        return priceBarService.getPriceBar();
    }

}
