package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.Log;
import com.cs4125.bookingapp.model.repositories.LogRepository;
import com.cs4125.bookingapp.services.Filter;
import com.google.common.annotations.Beta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class LogFilter implements Filter {

    @Autowired
    private LogRepository logRepository;

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
