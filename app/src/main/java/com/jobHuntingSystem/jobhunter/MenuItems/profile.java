package com.jobHuntingSystem.jobhunter.MenuItems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jobHuntingSystem.jobhunter.R;
import com.jobHuntingSystem.jobhunter.TheDatabase.DBHelper;
import com.jobHuntingSystem.jobhunter.TheDatabase.User;

import java.util.ArrayList;

public class profile extends AppCompatActivity {
    private com.jobHuntingSystem.jobhunter.TheDatabase.DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView ProfileTextView = (TextView) findViewById(R.id.ProfileTextView);
        TextView firstNameView = (TextView) findViewById(R.id.firstNameView);
        TextView lastNameView = (TextView) findViewById(R.id.lastNameView);
        TextView emailView = (TextView) findViewById(R.id.emailView);
        TextView DOBView = (TextView) findViewById(R.id.DOBView);
        TextView genderView = (TextView) findViewById(R.id.genderView);
        TextView phoneNumberView = (TextView) findViewById(R.id.phoneNumberView);
        TextView postalAddressView = (TextView) findViewById(R.id.postalAddressView);
        TextView countryView = (TextView) findViewById(R.id.countryView);
        TextView IDPassportView = (TextView) findViewById(R.id.IDPassportView);

        Button loadButton = (Button) findViewById(R.id.loadButton);

        dbHelper = new DBHelper(com.jobHuntingSystem.jobhunter.MenuItems.profile.this);

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userDetails ="";
                ArrayList<User> allUserDetails = (ArrayList<User>) dbHelper.getData();
                for (User user : allUserDetails){
                    userDetails = userDetails + user.getEmail();
                    userDetails = userDetails + user.getFirstName();
                    userDetails = userDetails + user.getLastName();
                    userDetails = userDetails + user.getGender();
                    userDetails = userDetails + user.getAddress();
                    userDetails = userDetails + user.getCountry();
                    userDetails = userDetails + user.getIDPassport();
                    userDetails = userDetails + user.getDOB();
                    userDetails = userDetails + user.getPhoneNumber();


                    Toast.makeText(getApplicationContext(),user.getFirstName().toString(),Toast.LENGTH_SHORT).show();
                }
                emailView.setText(userDetails);
                firstNameView.setText(userDetails);
                lastNameView.setText(userDetails);
                DOBView.setText(userDetails);
                genderView.setText(userDetails);
                phoneNumberView.setText(userDetails);
                postalAddressView.setText(userDetails);
                countryView.setText(userDetails);
                IDPassportView.setText(userDetails);

            }
        });
    }
}