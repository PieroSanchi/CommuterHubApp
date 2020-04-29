package com.example.commuterhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class Utilities {

    static final int ACTIVITY_ADD_CLOCK = 1;

    static void setUpToolBar(AppCompatActivity activity, String title) {
        Toolbar toolbar = activity.findViewById(R.id.app_bar);
        toolbar.setTitle(title);
        //set the toolbar as the action bar of this activity
        activity.setSupportActionBar(toolbar);
    }

    static void insertFragment(AppCompatActivity activity, Fragment fragment, String tag) {
        activity.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment, tag).commit();
    }

}
