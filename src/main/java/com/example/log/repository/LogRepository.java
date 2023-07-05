package com.example.log.repository;

import com.example.log.model.Log;

import java.util.List;

public interface LogRepository {
    List<Log> getAllLogs();

    Log getLogById(Long id);

    Log createLog(Log log);

    Log updateLog(Long id, Log log);

    void deleteLog(Long id);

    Long getLastId();
}
