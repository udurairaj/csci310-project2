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
        //user = (User)i.getSerializableExtra("user");
        user = new User("Uma Durairaj", "uduraira@usc.edu", "1234567890", "uduraira", "", "CS major");
        user.setUserID(9876);
        displayProfile(new View(this));
    }

    protected void displayProfile(View view) {
        TextView nameView = findViewById(R.id.nameProfileView);
        nameView.setText(user.getName());
        TextView userIDView = findViewById(R.id.userIDProfileView);
        userIDView.setText(String.valueOf(user.getUserID()));
        TextView usernameView = findViewById(R.id.usernameProfileView);
        usernameView.setText(user.getUsername());
        TextView emailView = findViewById(R.id.emailProfileView);
        emailView.setText(user.getEmail());
        TextView phoneView = findViewById(R.id.phoneProfileView);
        if (user.getPhone() != null) {
            phoneView.setText(user.getPhone());
        }
        else {
            phoneView.setText("");
        }
        ImageView profilePicView = (ImageView)findViewById(R.id.imageButton);
        if (user.getProfilePic() != null) {
            profilePicView.setImageURI(Uri.parse(user.getProfilePic()));
        }
        else {
            profilePicView.setImageResource(R.drawable.no_prof_pic);
        }
        TextView otherInfoView = findViewById(R.id.otherInfoProfileView);
        if (user.getOtherInfo() != null) {
            otherInfoView.setText(user.getOtherInfo());
        }
        else {
            otherInfoView.setText("");
        }
    }

    public void onClickEditProfile(View view) {
        Intent i = new Intent(getApplicationContext(), EditProfileActivity.class);
        i.putExtra("user", user);
        startActivity(i);
    }

}