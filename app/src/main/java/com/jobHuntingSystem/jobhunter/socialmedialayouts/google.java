package com.jobHuntingSystem.jobhunter.socialmedialayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jobHuntingSystem.jobhunter.R;
import com.jobHuntingSystem.jobhunter.SuccessfulLogin;

public class google extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google_activity);
        String name = "Job Hunter";

        Button googleSignIn = (Button) findViewById(R.id.googleSignIn);
        EditText googleUsername = (EditText) findViewById(R.id.googleUsername);
        EditText googlePassword = (EditText) findViewById(R.id.googlePassword);

        googleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(googleUsername.getText().toString().equals("bakangmonei2@gmail.com") && googlePassword.getText().toString().equals("admin")){
                    // Correct Password
                    Toast.makeText(google.this, "LOGIN Successful!!!! Welcome to the " + name, Toast.LENGTH_LONG).show();
                    Intent intentGoogleLogIn = new Intent(google.this, SuccessfulLogin.class);
                    startActivity(intentGoogleLogIn);
                }else
                    // Incorrect Password
                    Toast.makeText(google.this, "LOGIN FAILED!!!!!", Toast.LENGTH_LONG).show();

            }
        });
    }
}