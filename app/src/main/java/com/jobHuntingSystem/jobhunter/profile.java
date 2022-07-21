package com.jobHuntingSystem.jobhunter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

// Firebase
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {
    // private DBHelper dbHelper;

    // variable for Text view.
    private TextView retrieveTV;
    private DatabaseReference mRootRef;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Firebase
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //final DatabaseReference myRef = database.getReference("Users");

        mRootRef = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        TextView ProfileTextView = (TextView) findViewById(R.id.ProfileTextView);
        retrieveTV = (TextView) findViewById(R.id.detailsView);


        Button loadButton = (Button) findViewById(R.id.loadButton);

        getdata();
    }
    private void getdata() {

        // calling add value event listener method
        // for getting the values from database.
        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                String value = snapshot.getValue(String.class);

                // after getting the value we are setting
                // our value to our text view in below line.
                retrieveTV.setText(value + "\n");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(profile.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


/*public void onClick(View view) {
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

            }*/