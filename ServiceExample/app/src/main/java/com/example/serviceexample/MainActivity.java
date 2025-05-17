package com.example.serviceexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {

    AppCompatButton btnStart,btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart= findViewById(R.id.btnStart);
        btnStop= findViewById(R.id.btnStop);

        btnStart.setOnClickListener(view -> startService(new Intent(MainActivity.this, MusicService.class)));

        btnStop.setOnClickListener(view -> stopService(new Intent(MainActivity.this, MusicService.class)));
    }
}