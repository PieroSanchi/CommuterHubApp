package com.example.commuterhub.model;

import java.util.ArrayList;
import java.util.List;

public class AlarmSingleton {
    private List<Alarm> alarmList = new ArrayList<>();

    private static final AlarmSingleton ourIstance = new AlarmSingleton();

    public static AlarmSingleton getInstance() {
        return ourIstance;
    }

    private AlarmSingleton() {
    }

    public void addAlarm(Alarm alarm) {
        alarmList.add(alarm);
    }

    public List<Alarm> getAlarmList() {
        return alarmList;
    }

    public Alarm getAlarmItemList(int position) {
        return alarmList.get(position);
    }

}
