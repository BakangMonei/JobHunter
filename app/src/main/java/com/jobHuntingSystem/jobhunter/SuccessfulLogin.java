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

import org.w3c.dom.Text;

public class SuccessfulLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_login);

        // MenuItem
        MenuItem pro = (MenuItem) findViewById(R.id.profile);

        // ImageView
        ImageView ListView = (ImageView) findViewById(R.id.ListView);
        ImageView jobsAvailableImageView = (ImageView) findViewById(R.id.jobsAvailableImageView); //
        ImageView upload = (ImageView) findViewById(R.id.upload);
        ImageView print = (ImageView) findViewById(R.id.print);
        ImageView applyNow = (ImageView) findViewById(R.id.applyNow);
        ImageView search = (ImageView) findViewById(R.id.search); //
        ImageView pendingJobsImageView = (ImageView) findViewById(R.id.pendingJobsImageView);

        // TextView
        TextView mainMenu = (TextView) findViewById(R.id.mainMenu);
        TextView jobsAvailableTextView = (TextView) findViewById(R.id.jobsAvailableTextView);
        TextView uploadTextView = (TextView) findViewById(R.id.uploadTextView);
        TextView printTextView = (TextView) findViewById(R.id.printTextView);
        TextView applyNowTextView = (TextView) findViewById(R.id.applyNowTextView);
        TextView searchTextView = (TextView) findViewById(R.id.searchTextView);
        TextView pendingJobsTextV = (TextView) findViewById(R.id.pendingJobsTextV);



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
                        Intent intent = new Intent(SuccessfulLogin.this, com.jobHuntingSystem.jobhunter.MenuItems.profile.class);
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
                Intent intent = new Intent(SuccessfulLogin.this, com.jobHuntingSystem.jobhunter.AvailableJobs.jobsAvail.class);
                startActivity(intent);
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuccessfulLogin.this, "Search anything here", Toast.LENGTH_SHORT).show();
                Intent intentSearch = new Intent(SuccessfulLogin.this, com.jobHuntingSystem.jobhunter.MenuItems.SearchActivity.class);
                startActivity(intentSearch);
            }
        });
    }
}