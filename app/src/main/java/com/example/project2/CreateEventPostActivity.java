package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;

public class CreateEventPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event_post);
        Spinner statusPublicSpinner = findViewById(R.id.statusPublicSpinner);
        ArrayAdapter<CharSequence> a = ArrayAdapter.createFromResource
                (this, R.array.eventStatusArray, R.layout.activity_create_event_post);
        a.setDropDownViewResource(R.layout.activity_create_event_post);
        statusPublicSpinner.setAdapter(a);
    }

    public void onClickCreateEvent(View view) {
        EditText nameCreate = (EditText)findViewById(R.id.nameEventView);
        Spinner statusPublicCreate = (Spinner)findViewById(R.id.statusPublicSpinner);
        EditText descriptionCreate = (EditText)findViewById(R.id.descriptionEventView);
        //SearchView locationCreate = (SearchView)findViewById(R.id.locationEventSearch);
        // READ LOCATION HERE
        // READ TIME SLOTS HERE
        // READ SET DUE TIME HERE

        String createdName = nameCreate.getText().toString();
        //String createdStatusPublic = statusPublicCreate.
    }
}