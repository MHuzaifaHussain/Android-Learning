package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
Spinner spinner;


//int[] aarNo = new int[]{1,2,3,4,5,6,7}; Array Example
ArrayList<String> arrNames= new ArrayList<>();
ArrayList<String> arrIds= new ArrayList<>();
ArrayList<String> arrLang= new ArrayList<>();
AutoCompleteTextView autotxtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        autotxtView = findViewById(R.id.autotxtView);


        arrNames.add("Mustafa");
        arrNames.add("Kmankash");
        arrNames.add("Dilavir");
        arrNames.add("Ibrahim");
        arrNames.add("Ali");
        arrNames.add("Mustafa");
        arrNames.add("Kmankash");
        arrNames.add("Dilavir");
        arrNames.add("Ibrahim");
        arrNames.add("Ali");
        arrNames.add("Mustafa");
        arrNames.add("Kmankash");
        arrNames.add("Dilavir");
        arrNames.add("Ibrahim");
        arrNames.add("Ali");
        arrNames.add("Mustafa");
        arrNames.add("Kmankash");
        arrNames.add("Dilavir");
        arrNames.add("Ibrahim");
        arrNames.add("Ali");
        arrNames.add("Mustafa");
        arrNames.add("Kmankash");
        arrNames.add("Dilavir");
        arrNames.add("Ibrahim");
        arrNames.add("Ali");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position==0){
                    Toast.makeText(MainActivity.this, "Clicked first item", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        Spinner
        arrIds.add("CNIC");
        arrIds.add("Passport");
        arrIds.add("Driving Licence");
        arrIds.add("Utility Bill");
        arrIds.add("Health Card");


        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrIds);
        spinner.setAdapter(spinnerAdapter);

        // Auto complete text View

        arrLang.add("Arabic");
        arrLang.add("Chinese");
        arrLang.add("English");
        arrLang.add("Turkish");
        arrLang.add("Urdu");

        ArrayAdapter<String> autoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrLang);
        autotxtView.setAdapter(autoAdapter);
        autotxtView.setThreshold(1);

    }
}