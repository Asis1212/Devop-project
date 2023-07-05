package com.example.log.controller;

import com.example.log.model.Log;
//import com.example.log.service.LogService;
import com.example.log.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {
//    private final LogService logService;
    private final LogRepository logRepository;


    @Autowired
    public LogController(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @GetMapping
    public List<Log> getAllLogs() {
        return logRepository.getAllLogs();
    }

    @PostMapping
    public Log createLog(@RequestBody Log log) {
        Long nextId = logRepository.getLastId() + 1;
        log.setId(nextId);

        return logRepository.createLog(log);
    }

    @GetMapping("/{id}")
    public Log getLogById(@PathVariable Long id) {
        return logRepository.getLogById(id);
    }

    @PutMapping("/{id}")
    public Log updateLog(@PathVariable Long id, @RequestBody Log log) {
        return logRepository.updateLog(id, log);
    }

    @DeleteMapping("/{id}")
    public void deleteLog(@PathVariable Long id) {
        logRepository.deleteLog(id);
    }
}
