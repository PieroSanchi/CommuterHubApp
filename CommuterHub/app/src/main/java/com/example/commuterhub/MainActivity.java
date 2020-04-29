package com.example.commuterhub;

import android.os.Bundle;

import com.example.commuterhub.model.Alarm;
import com.example.commuterhub.model.AlarmSingleton;
import com.example.commuterhub.model.PlaceAlarm;
import com.example.commuterhub.model.TimeAlarm;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity - LAB";

    private static final String FRAGMENT_TAG = "homeFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            Utilities.insertFragment(this, new HomeFragment(), FRAGMENT_TAG);

            AlarmSingleton.getInstance().addAlarm(new TimeAlarm("svegliaUno", 10, 26));

            // CardItem cardItem1= new CardItem("Uni","Cesena",null);
            //CardItem cardItem2= new CardItem("Morning",null,"07:30");
            //CardSingleton.getInstance().addCardItem(cardItem1);
            // CardSingleton.getInstance().addCardItem(cardItem2);
        }

        refreshCardList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.refreshCardList();
    }

    public void refreshCardList() {
        CardSingleton.getInstance().clearAll();
        for (Alarm alarm : AlarmSingleton.getInstance().getAlarmList()) {
            if (alarm.getClass().equals(TimeAlarm.class)) { //se alarm è un TimeAlarm
                CardSingleton.getInstance().addCardItem(this.createTimeCardItem((TimeAlarm) alarm));
            } else {
                CardSingleton.getInstance().addCardItem(this.createPlaceCardItem((PlaceAlarm) alarm));
            }
        }
    }

    private CardItem createTimeCardItem(TimeAlarm alarm) {
        return new CardItem(alarm.getName(),  alarm.getTime());
    }

    private CardItem createPlaceCardItem(PlaceAlarm alarm) {
        return new CardItem(alarm.getName(), alarm.getCoordinates());
    }

}

