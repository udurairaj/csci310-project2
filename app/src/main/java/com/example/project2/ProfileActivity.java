package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class ProfileActivity extends AppCompatActivity {

    private User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent i = getIntent();
        user = (User)i.getSerializableExtra("user");
        displayProfile(new View(this));
    }

    protected void displayProfile(View view) {
//        TextView name = findViewById(R.id.name);
//        name.setText(user.getName());
//        TextView userID = findViewById(R.id.userID);
//        userID.setText(user.getUserID());
//        TextView username = findViewById(R.id.username);
//        username.setText(user.getUsername());
//        TextView email = findViewById(R.id.email);
//        email.setText(user.getEmail());
//        TextView phone = findViewById(R.id.phone);
//        phone.setText(user.getPhone());
//        ImageView profilePic = (ImageView)findViewById(R.id.profilePic);
//        Uri profilePicUri = Uri.parse(user.getProfilePic());
//        Bitmap profilePicBitmap = null;
//        try {
//            profilePicBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), profilePicUri);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (profilePicBitmap != null) {
//            profilePic.setImageBitmap(profilePicBitmap);
//        }
    }

//    public void onClickEditProfile(View view) {
//
//    }
//
//    public void onClickSetProfilePic(View View) {
//        Intent photoSelectIntent = new Intent(Intent.ACTION_GET_CONTENT, null);
//        photoSelectIntent.setType("image/*");
//
//    }

}