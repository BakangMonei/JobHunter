package com.jobHuntingSystem.jobhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class jobsAvail extends AppCompatActivity {

    String spane1 = "Java Lecture Portal", spane2 = "Python Lecture Portal", spane3 = "Networking Lecture Portal";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs_avail);
        TextView jobsTextView = (TextView) findViewById(R.id.jobsTextView);
        TextView job1 = (TextView) findViewById(R.id.job1);
        TextView job2 = (TextView) findViewById(R.id.job2);
        TextView job3 = (TextView) findViewById(R.id.job3);

        jobsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(jobsAvail.this, "Click any Job of your choice", Toast.LENGTH_SHORT).show();
            }
        });
        job1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(jobsAvail.this, "Welcome to " + spane1, Toast.LENGTH_SHORT).show();
                Intent intentJob1 = new Intent(jobsAvail.this, Job1Activity.class);
                startActivity(intentJob1);
            }
        });
        job2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(jobsAvail.this, "Welcome to " + spane2, Toast.LENGTH_SHORT).show();
                Intent intentJob2 = new Intent(jobsAvail.this, Job2Activity.class);
                startActivity(intentJob2);
            }
        });
        job3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(jobsAvail.this, "Welcome to " + spane3, Toast.LENGTH_SHORT).show();
                Intent intentJob3 = new Intent(jobsAvail.this, Job3Activity.class);
                startActivity(intentJob3);
            }
        });
    }
}