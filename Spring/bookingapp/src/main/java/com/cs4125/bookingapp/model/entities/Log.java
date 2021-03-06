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
    private Integer log_id;
    private String log_type;
    private Timestamp dateTime;

    public Log(){}

    public Log(Integer log_id, String log_type, Timestamp dateTime){
        this.log_id = log_id;
        this.log_type = log_type;
        this.dateTime = dateTime;
    }

    public Integer getLogId(){
        return this.log_id;
    }

    public void setLogId(Integer log_id){
        this.log_id = log_id;
    }

    public String getLogType(){
        return this.log_type;
    }

    public void setLogType(String log_type){
        this.log_type = log_type;
    }

    public Timestamp getDateTime(){
        return this.dateTime;
    }

    public void setDateTime(Timestamp dateTime){
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Log{" +
                "log_id=" + log_id +
                ", log_type=" + log_type +
                ", dateTime=" + dateTime +
                '}';
    }

}
