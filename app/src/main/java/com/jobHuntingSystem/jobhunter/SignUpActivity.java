package com.jobHuntingSystem.jobhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.*;

import com.jobHuntingSystem.jobhunter.TheDatabase.DBHelper;


public class SignUpActivity extends AppCompatActivity{

    // The Database
    private com.jobHuntingSystem.jobhunter.TheDatabase.DBHelper dbHelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        dbHelper = new DBHelper(SignUpActivity.this);

        TextView RegistrationName = (TextView) findViewById(R.id.RegistrationName);
        TextView firstNameView = (TextView) findViewById(R.id.firstNameView);
        TextView lastNameView = (TextView) findViewById(R.id.lastNameView);
        TextView emailView = (TextView) findViewById(R.id.emailView);
        TextView passwordView = (TextView) findViewById(R.id.passwordView);
        TextView repassView = (TextView) findViewById(R.id.repassView);
        TextView DOBView = (TextView) findViewById(R.id.DOBView);
        TextView genderView = (TextView) findViewById(R.id.genderView);
        TextView phoneNumberView = (TextView) findViewById(R.id.phoneNumberView);
        TextView postalAddressView = (TextView) findViewById(R.id.postalAddressView);
        TextView countryView = (TextView) findViewById(R.id.countryView);
        TextView IDPassportView = (TextView) findViewById(R.id.IDPassportView);

        EditText registerFirstName = (EditText) findViewById(R.id.registerFirstName);
        EditText registerLastName = (EditText) findViewById(R.id.registerLastName);
        EditText registerEmail = (EditText) findViewById(R.id.registerEmail);
        EditText registerPassword = (EditText) findViewById(R.id.registerPassword);
        EditText registerRePass = (EditText) findViewById(R.id.registerRePass);
        EditText registerDOB = (EditText) findViewById(R.id.registerDOB);
        EditText registerGender = (EditText) findViewById(R.id.registerGender);
        EditText registerPhoneNumber = (EditText) findViewById(R.id.registerPhoneNumber);
        EditText registerPostalAddress = (EditText) findViewById(R.id.registerPostalAddress);
        EditText registerCountry = (EditText) findViewById(R.id.registerCountry);
        EditText registerIDPass = (EditText) findViewById(R.id.registerIDPass);

        Button registerButton = (Button) findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = registerEmail.getText().toString().trim();
                String firstName = registerFirstName.getText().toString();
                String lastName = registerLastName.getText().toString();
                String Password = registerPassword.getText().toString();
                String rePassword = registerRePass.getText().toString();
                String DOB = registerDOB.getText().toString();
                String Gender = registerGender.getText().toString();
                String phoneNumber = registerPhoneNumber.getText().toString();
                String Address = registerPostalAddress.getText().toString();
                String Country = registerCountry.getText().toString();
                String IDPassport = registerIDPass.getText().toString();

                if(TextUtils.isEmpty(email) || (TextUtils.isEmpty(firstName)) || (TextUtils.isEmpty(lastName)) || (TextUtils.isEmpty(Password)) || (TextUtils.isEmpty(rePassword) || (TextUtils.isEmpty(DOB) || (TextUtils.isEmpty(Gender) || (TextUtils.isEmpty(phoneNumber) || (TextUtils.isEmpty(Address) || TextUtils.isEmpty(Country) || TextUtils.isEmpty(IDPassport)))))))
                {
                    Toast.makeText(SignUpActivity.this,"Please Enter All Details",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Password.length()<6 || rePassword.length() < 6){
                    Toast.makeText(SignUpActivity.this,"Password Too Short !",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Password == rePassword && rePassword == Password){
                    Toast.makeText(SignUpActivity.this,"Passwords do not match",Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    // On below line we are calling a method to add new user to sqlite data and pass all our values to it.
                    dbHelper.addNewUser(email, firstName, lastName, Gender, Address, Country, IDPassport, DOB, phoneNumber, Password, rePassword);
                     //courseNameEdt.setText("");
                    registerEmail.setText("");
                    registerFirstName.setText("");
                    registerLastName.setText("");
                    registerPassword.setText("");
                    registerRePass.setText("");
                    registerDOB.setText("");
                    registerGender.setText("");
                    registerPhoneNumber.setText("");
                    registerPostalAddress.setText("");
                    registerCountry.setText("");
                    registerIDPass.setText("");
                    // after adding the data we are displaying a toast message.
                    Toast.makeText(SignUpActivity.this, "Hi " + lastName + ", you have been added.", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}