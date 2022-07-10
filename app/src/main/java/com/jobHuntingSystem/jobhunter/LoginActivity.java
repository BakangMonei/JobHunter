package com.jobHuntingSystem.jobhunter;

/*
 * 1. Code the login button to get information from database
 * 2. Code the FinAid, Forgot Password and link to the SQLite(Using the update method)
 * 3. Create form for Application of Sponsorship
 * 4. Fix those login buttons for Facebook, Google, Instagram, and twitter with their methods
 * 5. Make userProfile get information for specific student using 'EMAIL' as primary key
 * 6.
 * */
/*
 * SignUp firebase done*/
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;
import android.content.Intent;


// For linking


import com.google.android.material.button.MaterialButton;
import com.jobHuntingSystem.jobhunter.TheDatabase.DBHelper;

public class LoginActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Boolean e=false, p=false;

        TextView email = (TextView) findViewById(R.id.username); //
        TextView password = (TextView) findViewById(R.id.password); //

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn); // Working
        MaterialButton forgotpass = (MaterialButton) findViewById(R.id.forgotpass); // Working (Layout Left)
        Button signUp = (Button) findViewById(R.id.sign); // Working

        ImageButton instasignup = (ImageButton) findViewById(R.id.instasignup);//
        ImageButton twittersignup = (ImageButton) findViewById(R.id.twittersignup);//
        ImageButton fbsignup = (ImageButton) findViewById(R.id.fbsignup);//
        ImageButton googlesignup = (ImageButton) findViewById(R.id.googlesignup);

        dbHelper = new DBHelper(LoginActivity.this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailCheck = email.getText().toString();
                String passCheck = password.getText().toString();
                if (email.getText().toString().equals("Admin@gmail.com") && password.getText().toString().equals("admin1234")){
                    Toast.makeText(LoginActivity.this, "LOGIN Successful!!!!", Toast.LENGTH_SHORT).show();
                    Intent intentLogIn = new Intent(LoginActivity.this, SuccessfulLogin.class);
                    startActivity(intentLogIn);
                }

            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Welcome to the SignUp", Toast.LENGTH_SHORT).show();
                Intent intentSignUp = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intentSignUp);
            }
        });
        instasignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Welcome! Please use your instagram details", Toast.LENGTH_SHORT).show();
                Intent intentInstagram = new Intent(LoginActivity.this, com.jobHuntingSystem.jobhunter.socialmedialayouts.instagram.class);
                startActivity(intentInstagram);
            }
        });
        twittersignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Welcome! Please use your Twitter details", Toast.LENGTH_SHORT).show();
                Intent intentTwitter = new Intent(LoginActivity.this, com.jobHuntingSystem.jobhunter.socialmedialayouts.twitter.class);
                startActivity(intentTwitter);
            }
        });
        fbsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Welcome! Please use your Facebook details", Toast.LENGTH_SHORT).show();
                Intent intentFacebook = new Intent(LoginActivity.this, com.jobHuntingSystem.jobhunter.socialmedialayouts.facebook.class);
                startActivity(intentFacebook);
            }
        });
        googlesignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Welcome! Please use your Google details", Toast.LENGTH_SHORT).show();
                Intent intentGoogle = new Intent(LoginActivity.this, com.jobHuntingSystem.jobhunter.socialmedialayouts.google.class);
                startActivity(intentGoogle);
            }
        });

        // To be fixed
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
                Intent intentGoogle = new Intent(LoginActivity.this, SuccessfulLogin.class);
                startActivity(intentGoogle);
            }
        });

    }
}