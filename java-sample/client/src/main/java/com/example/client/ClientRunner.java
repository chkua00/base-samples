package com.example.client;

import com.example.client.model.PriceBar;
import com.example.client.service.PriceBarService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ClientRunner implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(ClientRunner.class);

    @Autowired
    private PriceBarService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<PriceBar> bars = service.getPriceBar();
        for (PriceBar bar : bars) {
            System.out.println(bar.toString());
        }
    }

}
