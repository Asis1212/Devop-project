package com.example.log.seed;

import com.example.log.model.Log;
import com.example.log.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;


import javax.annotation.PostConstruct;

@Component
public class SeedData {
    private final LogRepository logRepository;

    @Autowired
    public SeedData(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @PostConstruct
    public void seedBooks() {
        Log log = new Log();
        log.setId(1L);
        log.setTimestamp(LocalDateTime.now());
        log.setRoute("SeedClass");
        logRepository.createLog(log);
    }
}
