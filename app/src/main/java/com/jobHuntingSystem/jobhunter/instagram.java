package com.jobHuntingSystem.jobhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class instagram extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instagram_activity);
        String name = "Job Hunter";

        EditText igUsername = (EditText) findViewById(R.id.igUsername);
        EditText igPassword = (EditText) findViewById(R.id.igPassword);

        Button igLogIn = (Button) findViewById(R.id.igLogIn);

        igLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(igUsername.getText().toString().equals("admin") && igPassword.getText().toString().equals("admin")){
                    // Correct Password
                    Toast.makeText(instagram.this, "LOGIN Successful!!!! Welcome to the " + name, Toast.LENGTH_LONG).show();
                    Intent intentInstaLogIn = new Intent(instagram.this, SuccessfulLogin.class);
                    startActivity(intentInstaLogIn);
                }else
                    // Incorrect Password
                    Toast.makeText(instagram.this, "LOGIN FAILED!!!!!", Toast.LENGTH_LONG).show();
            }
        });

    }
}