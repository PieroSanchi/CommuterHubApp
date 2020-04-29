package com.example.commuterhub.model;

public interface Alarm {

    Boolean isActive();

    void setActive(Boolean bool);

    Boolean isVibrationOn();

    void setVibration(Boolean bool);

    String getName();

    void setName(String name);

}
