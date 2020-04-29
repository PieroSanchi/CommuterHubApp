package com.example.commuterhub;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddClockActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clock);

        if (savedInstanceState == null) {
            Utilities.insertFragment(this, new AddFragmentClock(), "addFragment");
        }
    }
}
