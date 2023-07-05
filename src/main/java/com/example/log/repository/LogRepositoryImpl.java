package com.example.log.repository;

import com.example.log.model.Log;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LogRepositoryImpl implements LogRepository {
    private final Map<Long, Log> logs;

    public LogRepositoryImpl() {
        this.logs = new HashMap<>();
    }

    @Override
    public List<Log> getAllLogs() {
        return new ArrayList<>(logs.values());
    }

    @Override
    public Log getLogById(Long id) {
        return logs.get(id);
    }

    @Override
    public Log createLog(Log log) {
        logs.put(log.getId(), log);
        return log;
    }

    @Override
    public Log updateLog(Long id, Log log) {
        if (logs.containsKey(id)) {
            Log existingLog = logs.get(id);

            if (log.getTimestamp() != null) {
                existingLog.setTimestamp(log.getTimestamp());
            }
            if (log.getRoute() != null) {
                existingLog.setRoute(log.getRoute());
            }

            logs.put(id, existingLog);
            return existingLog;
        } else {
            throw new IllegalArgumentException("Book not found with ID: " + id);
        }
    }

    @Override
    public void deleteLog(Long id) {
        logs.remove(id);
    }

    @Override
    public Long getLastId() {
        return (long) logs.size();
    }

}
