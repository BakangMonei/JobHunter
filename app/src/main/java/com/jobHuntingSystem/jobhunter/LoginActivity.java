package com.jobHuntingSystem.jobhunter;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
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
    String name = "Neiza";

    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Boolean e=false, p=false;

        TextView signin = (TextView) findViewById(R.id.signin);
        TextView email = (TextView) findViewById(R.id.username); //
        TextView password = (TextView) findViewById(R.id.password); //

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn); // Working
        MaterialButton forgotpass = (MaterialButton) findViewById(R.id.forgotpass); // Working (Layout Left)
        Button signUp = (Button) findViewById(R.id.sign); // Working

        ImageButton instasignup = (ImageButton) findViewById(R.id.instasignup);//
        ImageButton twittersignup = (ImageButton) findViewById(R.id.twittersignup);//
        ImageButton fbsignup = (ImageButton) findViewById(R.id.fbsignup);//
        ImageButton googlesignup = (ImageButton) findViewById(R.id.googlesignup);//

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
                if(TextUtils.isEmpty(emailCheck) || TextUtils.isEmpty(passCheck) )
                {
                    Toast.makeText(LoginActivity.this,"Please Enter All Details",Toast.LENGTH_SHORT).show();
                    return;
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


        // Done with all these
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
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
                Intent intentGoogle = new Intent(LoginActivity.this, com.jobHuntingSystem.jobhunter.ForgotPasswordActivity.class);
                startActivity(intentGoogle);
            }
        });


        // Delete when done with the app
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Welcome to the application " + name, Toast.LENGTH_SHORT).show();
                Intent intentRemove = new Intent(LoginActivity.this, com.jobHuntingSystem.jobhunter.SuccessfulLogin.class);
                startActivity(intentRemove);
            }
        });

    }
}