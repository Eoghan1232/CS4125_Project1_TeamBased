package com.cs4125.bookingapp.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer logId;
    private String logType;
    private Timestamp timestamp;

    public Log(){}

    public Log(String logType, Timestamp timestamp){
        this.logType = logType;
        this.timestamp = timestamp;
    }

    public Integer getLogId(){
        return this.logId;
    }

    public void setLogId(Integer logId){
        this.logId = logId;
    }

    public String getLogType(){
        return this.logType;
    }

    public void setLogType(String logType){
        this.logType = logType;
    }

    public Timestamp getDateTime(){
        return this.timestamp;
    }

    public void setDateTime(Timestamp dateTime){
        this.timestamp = dateTime;
    }

    @Override
    public String toString() {
        return "Log{" +
                "log_id=" + logId +
                ", log_type=" + logType +
                ", dateTime=" + timestamp +
                '}';
    }

}
