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
//        TextView nameView = findViewById(R.id.name);
//        nameView.setText(user.getName());
//        TextView userIDView = findViewById(R.id.userID);
//        userIDView.setText(user.getUserID());
//        TextView usernameView = findViewById(R.id.username);
//        usernameView.setText(user.getUsername());
//        TextView emailView = findViewById(R.id.email);
//        emailView.setText(user.getEmail());
//        TextView phoneView = findViewById(R.id.phone);
//        phoneView.setText(user.getPhone());
//        ImageView profilePicView = (ImageView)findViewById(R.id.profilePic);
//        profilePicView.setImageURI(Uri.parse(user.getProfilePic()));
//        TextView otherInfoView = findViewById(R.id.otherInfo);
//        otherInfoView.setText(user.getOtherInfo());
    }

    public void onClickEditProfile(View view) {
        Intent i = new Intent(ProfileActivity.this, EditProfileActivity.class);
        startActivity(i);
        i.putExtra("user", user);
    }

}