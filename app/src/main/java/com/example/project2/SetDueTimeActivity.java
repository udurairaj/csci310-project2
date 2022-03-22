package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SetDueTimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_due_time);
    }

    public void onClickSetDueTime(View view) {
        // get date and time from spinners
        // create intent to switch back to create event page
        // pass date and time back to create event page
        // pass back event info already added to create event page
    }
}