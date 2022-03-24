package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        // if user is owner, edit button
        // if user is invited, join or decline button
        // if user is accepted, withdraw button
        // if user is viewing public event, join button


        // if time generated, set final time and remove time options
    }

    public void onClickEventDetailsButton(View view) {
        // if user is owner, transfer to create event page
        // if user is joins event, add to event
        // if user withdraws from event, remove from event and return to home page
        // if user joins event, add to event

        // MIGHT NEED SEPARATE FUNCTIONS FOR EACH BUTTON OPTION
    }
}