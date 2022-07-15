package com.jobHuntingSystem.jobhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jobHuntingSystem.jobhunter.TheDatabase.DBHelper;

public class ForgotPasswordActivity extends AppCompatActivity {

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        dbHelper = new DBHelper(this);

        TextView forgotPassWordTextView = (TextView) findViewById(R.id.forgotPassWordTextView);
        TextView emailTextView = (TextView) findViewById(R.id.emailTextView);
        TextView passwordTextView = (TextView) findViewById(R.id.passwordTextView);
        TextView rePasswordTextView = (TextView) findViewById(R.id.rePasswordTextView);

        Button updatePassword = (Button) findViewById(R.id.updatePassword);

        EditText changeUsername = (EditText) findViewById(R.id.changeUsername);
        EditText changePassword = (EditText) findViewById(R.id.changePassword);
        EditText changeRePassword = (EditText) findViewById(R.id.changeRePassword);

        updatePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = changeUsername.getText().toString().trim();
                String pass = changePassword.getText().toString().trim();
                String rePass = changeRePassword.getText().toString().trim();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(rePass) )
                {
                    Toast.makeText(ForgotPasswordActivity.this,"Please Enter All Details",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(pass.length()<6 || rePass.length() < 6){
                    Toast.makeText(ForgotPasswordActivity.this,"Password Too Short !",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(pass == rePass && rePass == pass){
                    Toast.makeText(ForgotPasswordActivity.this,"Passwords do not match",Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    dbHelper.changeForgottenPass();
                    Toast.makeText(ForgotPasswordActivity.this,"Successfully Changed", Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}