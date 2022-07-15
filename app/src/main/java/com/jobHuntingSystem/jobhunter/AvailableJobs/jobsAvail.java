package com.jobHuntingSystem.jobhunter.AvailableJobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jobHuntingSystem.jobhunter.AvailableJobs.jobsForApplying.Job3Activity;
import com.jobHuntingSystem.jobhunter.R;

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
                return;
            }
        });
        job1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(jobsAvail.this, "Welcome to " + spane1, Toast.LENGTH_SHORT).show();
                Intent intentJob1 = new Intent(jobsAvail.this, com.jobHuntingSystem.jobhunter.AvailableJobs.jobsForApplying.Job1Activity.class);
                startActivity(intentJob1);
                return;
            }
        });
        job2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(jobsAvail.this, "Welcome to " + spane2, Toast.LENGTH_SHORT).show();
                Intent intentJob2 = new Intent(jobsAvail.this, com.jobHuntingSystem.jobhunter.AvailableJobs.jobsForApplying.Job2Activity.class);
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