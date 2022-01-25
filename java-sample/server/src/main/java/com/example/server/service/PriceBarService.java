package com.example.server.service;

import com.example.server.model.PriceBar;
import com.example.server.repository.PriceBarRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceBarService {

    private static final Logger log = LoggerFactory.getLogger(PriceBarService.class);

    @Autowired
    private PriceBarRepository repository;

    public List<PriceBar> getPriceBar() {
        return repository.findAll();
    }

}
