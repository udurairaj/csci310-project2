package com.example.project2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    User user = null;
    ImageView profilePic = null;

    ActivityResultLauncher<String> arl = registerForActivityResult
            (new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    //profilePic.setImageURI(result);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Intent i = getIntent();
        user = (User)i.getSerializableExtra("user");
        //profilePic = (ImageView)findViewById(R.id.profilePic);
        editResults(new View(this));
    }

    protected void editResults(View view) {

    }

    // add onclick to set profile pic button
    public void onClickSetProfilePic(View View) {
        arl.launch("image/*");
    }

}