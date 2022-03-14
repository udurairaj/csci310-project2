package com.example.project2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private User loginUser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    // Call when login button gets clicked
//    public void onClickLogIn(View view) {
//        EditText usernameField = (EditText)findViewById(R.id.username);
//        EditText passwordField = (EditText)findViewById(R.id.password);
//        String username = usernameField.getText().toString();
//        String password = passwordField.getText().toString();
//        if (username.length() == 0) {
//            usernameField.setError("Please enter your username.");
//        }
//        if (password.length() == 0) {
//            passwordField.setError("Please enter your password.");
//        }
//        loginUser = new User(username, password);
//        int valid = loginUser.validate();
//        if (valid >= 0) {
//            User u = null;
//            // u = DATABASE FUNCTION TO GET USER
//            Intent i = new Intent(LoginActivity.this, ProfileActivity.class);
//            startActivity(i);
//            i.putExtra("user", u);
//        }
//        else {
//            AlertDialog.Builder loginFail = new AlertDialog.Builder(this);
//            loginFail.setMessage("Incorrect username or password. Please try again.");
//            loginFail.setTitle("Error");
//            loginFail.setPositiveButton("Close", null);
//            loginFail.create().show();
//        }
//    }
}