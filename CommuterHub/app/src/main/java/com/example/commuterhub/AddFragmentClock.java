package com.example.commuterhub;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class AddFragmentClock extends Fragment {

    //private static final String LOG = "Add-Fragment_LAB";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_add_clock, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Set the content of the activity to use the  activity_main.xml layout file
        Objects.requireNonNull(getActivity()).setContentView(R.layout.fragment_add_clock);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = getActivity().findViewById(R.id.viewPager);

        // Create an adapter that knows which fragment should be shown on each page
        final FragmentAdapter adapter = new FragmentAdapter(getActivity(), getActivity().getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = getActivity().findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private boolean inputNotEmpty(@Nullable Editable text) {
        return text != null && text.length() > 0;
    }
}


    /* @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_add_clock, container, false);
    } */

  /*  @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final Activity activity = getActivity();

        Utilities.setUpToolBar((AppCompatActivity) getActivity(), getString(R.string.add_alarm));

        Calendar calendar = Calendar.getInstance();
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);

        TextView displayTimeTextView = (TextView) getActivity().findViewById(R.id.displayTimeTextView);
        displayTimeTextView.setText(hour+":"+minute);
        Button btnShowTimePicker = activity.findViewById(R.id.btnShowTimePicker);

        btnShowTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(activity, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        TextView displayTimeTextView = (TextView) getActivity().findViewById(R.id.displayTimeTextView);
                        displayTimeTextView.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, android.text.format.DateFormat.is24HourFormat(activity));
                timePickerDialog.show();
            }
        });
    } */

