package com.jobHuntingSystem.jobhunter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    String[] attributeNamesList;
    ArrayList<attributeNames> arraylist = new ArrayList<attributeNames>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Generate sample data
        attributeNamesList = new String[]{"First Name", "Last Name", "Gender",
                "DOB", "Email", "Address", "Country",
                "ID/Passport ","phone Number"};
        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < attributeNamesList.length; i++) {
            attributeNames animalNames = new attributeNames(attributeNamesList[i]);
            // Binds all strings into an array
            arraylist.add(animalNames);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        SearchView simpleSearchView = (SearchView) findViewById(R.id.searchIcon);
        CharSequence query = simpleSearchView.getQuery(); // get the query string currently in the text field
        CharSequence queryHint = simpleSearchView.getQueryHint(); // get the hint text that will be displayed in the query text field
        simpleSearchView.setIconifiedByDefault(false);  // set the default or resting state of the search field
        simpleSearchView.setQueryHint("Search View"); // set the hint text to display in the query text field

        // perform set on query text focus change listener event
        simpleSearchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
            // do something when the focus of the query text field changes
            }
            public boolean onQueryTextSubmit(String query) {
            // do something on text submit
                return false;
            }
            public boolean onQueryTextChange(String newText) {
            // do something when text changes
                return false;
            }
        });

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}