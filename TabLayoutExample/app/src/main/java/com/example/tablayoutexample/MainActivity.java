package com.example.tablayoutexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
TabLayout tab;
ViewPager2 viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab= findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);


        ViewPagerMessengerAdapter adapter=new ViewPagerMessengerAdapter(this);
        viewPager.setAdapter(adapter);

        new ViewPagerMessengerAdapter(this);

    }
}