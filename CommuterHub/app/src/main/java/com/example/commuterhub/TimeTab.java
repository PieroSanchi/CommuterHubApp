package com.example.commuterhub;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.commuterhub.model.AlarmSingleton;
import com.example.commuterhub.model.TimeAlarm;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import static android.app.Activity.RESULT_OK;

public class TimeTab extends Fragment {

    private TextInputEditText titleTextInputEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_time_tab, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final Activity activity = getActivity();

        titleTextInputEditText = activity.findViewById(R.id.titleTextInputEditText);

        Utilities.setUpToolBar((AppCompatActivity) getActivity(), getString(R.string.add_alarm));

        Calendar calendar = Calendar.getInstance();
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);

        TextView displayTimeTextView = getActivity().findViewById(R.id.displayTimeTextView);
        displayTimeTextView.setText(hour + ":" + minute);
        Button btnShowTimePicker = activity.findViewById(R.id.btnShowTimePicker);

        btnShowTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(activity, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        TextView displayTimeTextView = getActivity().findViewById(R.id.displayTimeTextView);
                        displayTimeTextView.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, android.text.format.DateFormat.is24HourFormat(activity));
                timePickerDialog.show();
            }
        });

        //PER FAB BUTTON
        FloatingActionButton floatingActionButton = getActivity().findViewById(R.id.fab_add);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CONTROLLO CHE LA EDITTEXT NON SIA NULLA
                if (inputNotEmpty(titleTextInputEditText.getText())) {
                    //CardSingleton.getInstance().addCardItem(new CardItem(titleTextInputEditText.getText().toString(), null, "10.10"));
                    AlarmSingleton.getInstance().addAlarm(new TimeAlarm(titleTextInputEditText.getText().toString(), 10, 10)); //IMMETTERE ORA E MINUTO DALLA TEXTVIEW

                    //AlarmSingleton.getInstance().refreshCardList();

                    getActivity().setResult(RESULT_OK);
                    getActivity().finish();
                } else {
                    titleTextInputEditText.setError(getString(R.string.name_empty));
                }
            }
        });

    }

    private boolean inputNotEmpty(@Nullable Editable text) {
        return text != null && text.length() > 0;
    }

}
