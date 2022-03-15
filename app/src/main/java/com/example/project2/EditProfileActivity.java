package com.example.project2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URI;

public class EditProfileActivity extends AppCompatActivity {

    User user = null;
    Boolean success = true;

    EditText nameEdit = null;
    EditText usernameEdit = null;
    EditText emailEdit = null;
    EditText phoneEdit = null;
    ImageView profilePicEdit = null;
    EditText otherInfoEdit = null;

    ActivityResultLauncher<String> arl = registerForActivityResult
            (new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    profilePicEdit.setImageURI(result);
                    user.setProfilePic(result.toString());
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Intent i = getIntent();
        user = (User)i.getSerializableExtra("user");

        nameEdit = (EditText)findViewById(R.id.nameProfileView);
        usernameEdit = (EditText)findViewById(R.id.usernameProfileView);
        emailEdit = (EditText)findViewById(R.id.emailProfileView);
        phoneEdit = (EditText)findViewById(R.id.phoneProfileView);
        profilePicEdit = (ImageView)findViewById(R.id.imageButton);
        otherInfoEdit = (EditText)findViewById(R.id.otherInfoProfileView);

        nameEdit.setText(user.getName());
        usernameEdit.setText(user.getUsername());
        emailEdit.setText(user.getEmail());
        if (user.getPhone() != null) {
            phoneEdit.setText(user.getPhone());
        }
        if (user.getProfilePic() != null) {
            profilePicEdit.setImageURI(Uri.parse(user.getProfilePic()));
        }
        else {
            profilePicEdit.setImageResource(R.drawable.no_prof_pic);
        }
        if (user.getOtherInfo() != null) {
            otherInfoEdit.setText(user.getOtherInfo());
        }
    }

    public void onClickSaveEdits(View view) {
        EditText nameEdit = (EditText)findViewById(R.id.nameProfileView);
        EditText usernameEdit = (EditText)findViewById(R.id.usernameProfileView);
        EditText emailEdit = (EditText)findViewById(R.id.emailProfileView);
        EditText phoneEdit = (EditText)findViewById(R.id.phoneProfileView);
        ImageView profilePicEdit = (ImageView)findViewById(R.id.imageButton);
        EditText otherInfoEdit = (EditText)findViewById(R.id.otherInfoProfileView);

        String editedName = nameEdit.getText().toString();
        if (editedName.length() == 0) {
            nameEdit.setError("Name is required.");
            success = false;
        }
        else {
            user.setName(editedName);
        }

        String editedUsername = usernameEdit.getText().toString();
        if (editedUsername.length() == 0) {
            usernameEdit.setError("Username is required");
            success = false;
        }
        // ELSE IF USERNAME FOUND IN DB, ERROR
        else {
            user.setUsername(editedUsername);
        }

        String editedEmail = emailEdit.getText().toString();
        if (editedEmail.length() == 0) {
            emailEdit.setError("Email is required");
            success = false;
        }
        else {
            user.setEmail(editedEmail);
        }

        String editedPhone = phoneEdit.getText().toString();
        if (editedPhone.length() == 0) {
            user.setPhone(null);
        }
        else {
            user.setPhone(editedPhone);
        }

        String editedOtherInfo = otherInfoEdit.getText().toString();
        if (editedOtherInfo.length() == 0) {
            user.setOtherInfo(null);
        }
        else if (editedOtherInfo.length() > 120) {
            otherInfoEdit.setError("Max 120 characters.");
            success = false;
        }
        else {
            user.setOtherInfo(editedOtherInfo);
        }

        if (success) {
            Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
            i.putExtra("user", user);
            startActivity(i);
        }
    }

    public void onClickSetProfilePic(View View) {
        arl.launch("image/*");
    }

}