package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

public class CreateEventPostActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    private Spinner statusPublicSpinner = null;
    private String[] eventStatus = { "public", "private" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event_post);

        statusPublicSpinner = findViewById(R.id.statusPublicSpinner);
        statusPublicSpinner.setOnItemSelectedListener(this);
        ArrayAdapter a = new ArrayAdapter(this, R.layout.activity_create_event_post, eventStatus);
        a.setDropDownViewResource(R.layout.activity_create_event_post);
        statusPublicSpinner.setAdapter(a);
    }

    public void onClickCreateEvent(View view) {
        EditText nameCreate = (EditText)findViewById(R.id.nameEventView);
        EditText descriptionCreate = (EditText)findViewById(R.id.descriptionEventView);
        //SearchView locationCreate = (SearchView)findViewById(R.id.locationEventSearch);
        // READ LOCATION HERE
        // READ TIME SLOTS HERE
        // READ SET DUE TIME HERE FROM INTENT

        String createdName = nameCreate.getText().toString();
        //String createdStatusPublic = statusPublicCreate.
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), eventStatus [position], Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> parent) {}
}