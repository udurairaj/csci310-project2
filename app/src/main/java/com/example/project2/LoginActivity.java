package com.example.project2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private User loginUser = null;
    private User signupUser = null;
    private Boolean successLogin = true;
    private Boolean successSignup = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    // Call when login button gets clicked
    public void onClickLogIn(View view) {
        EditText usernameField = (EditText)findViewById(R.id.usernameLoginBox);
        EditText passwordField = (EditText)findViewById(R.id.passwordLoginBox);
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        if (username.length() == 0) {
            usernameField.setError("Please enter your username.");
            successLogin = false;
        }
        if (password.length() == 0) {
            passwordField.setError("Please enter your password.");
            successLogin = false;
        }
        loginUser = new User(username, password);
        int valid = loginUser.validate();
        if (valid >= 0 && successLogin) {
            //User u = null;
            // u = DATABASE FUNCTION TO GET USER FROM USERID
            Intent i = new Intent(LoginActivity.this, ProfileActivity.class);
            startActivity(i);
            //i.putExtra("user", u);
        }
        else {
            AlertDialog.Builder loginFail = new AlertDialog.Builder(this);
            loginFail.setMessage("Incorrect username or password. Please try again.");
            loginFail.setTitle("Error");
            loginFail.setPositiveButton("Close", null);
            loginFail.create().show();
        }
        successLogin = true; // reset success flag
    }

    public void onClickSignUp(View view) {
        EditText usernameField = (EditText)findViewById(R.id.usernameSignupBox);
        EditText passwordField = (EditText)findViewById(R.id.passwordSignupBox);
        EditText nameField = (EditText)findViewById(R.id.nameSignupBox);
        EditText emailField = (EditText)findViewById(R.id.emailSignupBox);
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        if (username.length() == 0) {
            usernameField.setError("Please enter your username.");
            successSignup = false;
        }
        // ELSE IF USERNAME EXISTS IN DB, ERROR

        if (password.length() == 0) {
            passwordField.setError("Please enter your password.");
            successSignup = false;
        }
        else if (password.length() < 8) {
            passwordField.setError("Password must be at least 8 characters.");
            successSignup = false;
        }
        if (name.length() == 0) {
            nameField.setError("Please enter your name.");
            successSignup = false;
        }
        if(email.length() == 0) {
            emailField.setError("Please enter your email.");
            successSignup = false;
        }
        // ELSE IF EMAIL EXISTS IN DB, ERROR

        if (successSignup) {
            signupUser = new User(name, email, username, password);
            // ADD USER TO DATABASE AND GET USER ID
            // User u = GET USER FROM DB BY USER ID
            Intent i = new Intent(LoginActivity.this, ProfileActivity.class);
            startActivity(i);
            //i.putExtra("user", u);
        }
        else {
            AlertDialog.Builder loginFail = new AlertDialog.Builder(this);
            loginFail.setMessage("Please fix errors and try again.");
            loginFail.setTitle("Error");
            loginFail.setPositiveButton("Close", null);
            loginFail.create().show();
        }

        successSignup = true; // reset success flag
    }

}