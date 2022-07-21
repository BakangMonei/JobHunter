package com.jobHuntingSystem.jobhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class SuccessfulLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_login);

        // MenuItem
        MenuItem pro = (MenuItem) findViewById(R.id.profile);

        // ImageView
        ImageView ListView = (ImageView) findViewById(R.id.ListView); // Done & Working
        ImageView jobsAvailableImageView = (ImageView) findViewById(R.id.jobsAvailableImageView); // Done & Working
        ImageView upload = (ImageView) findViewById(R.id.upload); // Done & Working
        ImageView applyNow = (ImageView) findViewById(R.id.applyNow); // Done & Working
        ImageView search = (ImageView) findViewById(R.id.search); // Done & Working
        ImageView pendingJobsImageView = (ImageView) findViewById(R.id.pendingJobsImageView); // Done & Working
        ImageView print = (ImageView) findViewById(R.id.print); //
        ImageView mapImageView = (ImageView) findViewById(R.id.mapImageView); // Done & Working
        ImageView logOutImageView = (ImageView) findViewById(R.id.logOutImageView); // Done & Working

        // TextView
        TextView mainMenu = (TextView) findViewById(R.id.mainMenu);
        TextView jobsAvailableTextView = (TextView) findViewById(R.id.jobsAvailableTextView);
        TextView uploadTextView = (TextView) findViewById(R.id.uploadTextView);
        TextView printTextView = (TextView) findViewById(R.id.printTextView);
        TextView applyNowTextView = (TextView) findViewById(R.id.applyNowTextView);
        TextView searchTextView = (TextView) findViewById(R.id.searchTextView);
        TextView pendingJobsTextV = (TextView) findViewById(R.id.pendingJobsTextV);
        TextView logOutTextV = (TextView) findViewById(R.id.logOutTextV);
        TextView mapTextView = (TextView) findViewById(R.id.mapTextView);




        ListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initializing the popup menu and giving the reference as current context
                PopupMenu popupMenu = new PopupMenu(SuccessfulLogin.this, ListView);

                // Inflating popup menu from popup_menu.xml file
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        // Toast message on menu item clicked
                        Toast.makeText(SuccessfulLogin.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SuccessfulLogin.this, profile.class);
                        startActivity(intent);
                        return true;
                    }
                });
                // Showing the popup menu
                popupMenu.show();
            }
        });
        jobsAvailableImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuccessfulLogin.this, "Welcome to job views", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SuccessfulLogin.this, jobsAvail.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuccessfulLogin.this, "Search anything here", Toast.LENGTH_SHORT).show();
                Intent intentSearch = new Intent(SuccessfulLogin.this, SearchActivity.class);
                startActivity(intentSearch);
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuccessfulLogin.this, "Click The Image to Upload", Toast.LENGTH_SHORT).show();
                Intent intentUpload = new Intent(SuccessfulLogin.this, UploadActivity.class);
                startActivity(intentUpload);
            }
        });
        applyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuccessfulLogin.this, "Welcome to The Apply For Job section", Toast.LENGTH_SHORT).show();
                Intent applyIntent = new Intent(SuccessfulLogin.this, ApplyNowActivity.class);
                startActivity(applyIntent);
            }
        });
        pendingJobsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuccessfulLogin.this, "Welcome to Pending Jobs section", Toast.LENGTH_SHORT).show();
                Intent intentPendingJobs = new Intent(SuccessfulLogin.this, pendingJobs.class);
                startActivity(intentPendingJobs);
            }
        });
        logOutImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuccessfulLogin.this, "Successfully Logged Out", Toast.LENGTH_SHORT).show();
                Intent intentSignOut = new Intent(SuccessfulLogin.this, LoginActivity.class);
                startActivity(intentSignOut);
            }
        });
        mapImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuccessfulLogin.this, "Welcome To Google Map", Toast.LENGTH_SHORT).show();
                Intent intentSignOut = new Intent(SuccessfulLogin.this, MapsActivity.class);
                startActivity(intentSignOut);
            }
        });
    }
}