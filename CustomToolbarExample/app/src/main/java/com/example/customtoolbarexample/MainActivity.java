package com.example.customtoolbarexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        toolbar = findViewById(R.id.toolbar);
//        Step 1

        
        setSupportActionBar(toolbar);
//        setActionBar(); ---> use for previous version of toolbar--ok
        
//        step 2
        if (getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("My Toolbar");

        }
        
        
        toolbar.setTitle("My Toolbar");
        toolbar.setSubtitle("Sub Title");
    }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.opt_new) {
            Toast.makeText(this, "Created New File", Toast.LENGTH_SHORT).show();

        }else if (itemId == R.id.opt_open){
            Toast.makeText(this, "File Opened", Toast.LENGTH_SHORT).show();

        }else if (itemId == android.R.id.home){
            super.onBackPressed();
        }else{
            Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show();

        }
        
        return super.onOptionsItemSelected(item);
    }
}