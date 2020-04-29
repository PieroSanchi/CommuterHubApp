package com.example.commuterhub.model;

public class TimeAlarm implements Alarm {

    private Boolean isActive, isVibrationOn;
    private String name;
    private int hour,minute;
    //inserire campo suoneria (?)


    public TimeAlarm(String name, int hour, int minute) {
        this.name = name;
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getTime(){
        return (this.hour+":"+this.minute);
    }

    @Override
    public Boolean isActive() {
        return this.isActive;
    }

    @Override
    public void setActive(Boolean bool) {
        this.isActive=bool;
    }

    @Override
    public Boolean isVibrationOn() {
        return isVibrationOn;
    }

    @Override
    public void setVibration(Boolean bool) {
        this.isVibrationOn=bool;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }
}
