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

public class EditProfileActivity extends AppCompatActivity {

    User user = null;
    ImageView profilePic = null;
    String profilePicImageUri;
    Boolean success = true;

    ActivityResultLauncher<String> arl = registerForActivityResult
            (new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    //profilePic.setImageURI(result);
                    profilePicImageUri = result.toString();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Intent i = getIntent();
        user = (User)i.getSerializableExtra("user");
        //profilePic = (ImageView)findViewById(R.id.profilePic);
        profilePicImageUri = user.getProfilePic();
    }

//    protected void onClickSaveEdits(View view) {
//        EditText nameEdit = (EditText)findViewById(R.id.name);
//        EditText usernameEdit = (EditText)findViewById(R.id.username);
//        EditText emailEdit = (EditText)findViewById(R.id.email);
//        EditText phoneEdit = (EditText)findViewById(R.id.phone);
//        ImageView profilePicEdit = (ImageView)findViewById(R.id.profilePic);
//        EditText otherInfoEdit = (EditText)findViewById(R.id.otherInfo);
//
//        String editedName = nameEdit.getText().toString();
//        if (editedName.length() == 0) {
//            nameEdit.setError("Name is required.");
//            success = false;
//        }
//        user.setName(editedName);
//
//        String editedUsername = usernameEdit.getText().toString();
//        if (editedUsername.length() == 0) {
//            usernameEdit.setError("Username is required");
//            success = false;
//        }
//        // ELSE IF USERNAME FOUND IN DB, ERROR
//        user.setUsername(editedUsername);
//
//        String editedEmail = emailEdit.getText().toString();
//        if (editedEmail.length() == 0) {
//            emailEdit.setError("Email is required");
//            success = false;
//        }
//        user.setEmail(editedEmail);
//
//        String editedPhone = phoneEdit.getText().toString();
//        String phoneRegex = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$\n";
//        if (editedPhone.matches(phoneRegex)) {
//            user.setPhone(editedPhone);
//        }
//        else {
//            user.setPhone(null);
//        }
//
//        profilePicEdit.setImageURI(Uri.parse(profilePicImageUri));
//
//        String editedOtherInfo = otherInfoEdit.getText().toString();
//        if (editedOtherInfo.length() == 0) {
//            user.setOtherInfo(null);
//        }
//        else {
//            user.setOtherInfo(editedOtherInfo);
//        }
//
//        if (success) {
//            Intent i = new Intent(EditProfileActivity.this, ProfileActivity.class);
//            startActivity(i);
//            i.putExtra("user", user);
//        }
//    }

    public void onClickSetProfilePic(View View) {
        arl.launch("image/*");
    }

}