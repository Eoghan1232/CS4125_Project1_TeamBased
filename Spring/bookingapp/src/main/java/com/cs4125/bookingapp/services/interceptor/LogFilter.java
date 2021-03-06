package com.cs4125.bookingapp.services.interceptor;

import com.cs4125.bookingapp.model.entities.Log;
import com.cs4125.bookingapp.model.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class LogFilter implements Filter {

    private final LogRepository logRepository;

    @Autowired
    public LogFilter(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void execute(String request) {
        Log log = new Log();

        String str[] = request.split(",");

        Timestamp currentDateTime = Timestamp.valueOf(LocalDateTime.now());
        log.setLogType(str[0] + " Request");
        log.setDateTime(currentDateTime);

        logRepository.save(log);
    }
}
