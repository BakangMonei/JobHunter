package com.jobHuntingSystem.jobhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class facebook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facebook_activity);
        String name = "Job Hunter";

        MaterialButton fbLogin = (MaterialButton) findViewById(R.id.fbLogin);
        EditText fbPassword = (EditText) findViewById(R.id.fbPassword);
        EditText fbUsername = (EditText) findViewById(R.id.fbUsername);

        fbLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fbUsername.getText().toString().equals("admin") && fbPassword.getText().toString().equals("admin")){
                    // Correct Password
                    Toast.makeText(facebook.this, "LOGIN Successful!!!! Welcome to the " + name, Toast.LENGTH_LONG).show();
                    Intent intentFBLogIn = new Intent(facebook.this, SuccessfulLogin.class);
                    startActivity(intentFBLogIn);
                }else
                    // Incorrect Password
                    Toast.makeText(facebook.this, "LOGIN FAILED!!!!!", Toast.LENGTH_LONG).show();
            }
        });
    }
}