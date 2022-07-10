package com.jobHuntingSystem.jobhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.jobHuntingSystem.jobhunter.jobsAvailable.jobsAvail;

public class SuccessfulLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_login);
        ImageView ListView = (ImageView) findViewById(R.id.ListView);
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
                        return true;
                    }
                });
                // Showing the popup menu
                popupMenu.show();
            }
        });

        ImageView jobsAvailableImageView = (ImageView) findViewById(R.id.jobsAvailableImageView);
        jobsAvailableImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuccessfulLogin.this, "Welcome to job views", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SuccessfulLogin.this, jobsAvail.class);
                startActivity(intent);
            }
        });
    }
}