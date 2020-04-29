package com.example.commuterhub.model;

public class PlaceAlarm implements Alarm {

    private Boolean isActive, isVibrationOn;
    private String name,latitude, longitude;

    public PlaceAlarm(String name, String latitude, String longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCoordinates(){
        return "PLACE"; //TODO
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
