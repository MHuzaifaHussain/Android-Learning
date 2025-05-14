package com.example.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnView= findViewById(R.id.bnView);


        bnView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id==R.id.nav_home){
                loadFrag(new AFragment(), false);

            }else if (id==R.id.nav_search){
                loadFrag(new BFragment(), false);

            }else if (id==R.id.nav_utilities){
                loadFrag(new CFragment(), false);

            }else if (id==R.id.nav_contact){
                loadFrag(new DFragment(), false);

            }else{
                loadFrag(new EFragment(), true);

            }
            return true;
        });
        bnView.setSelectedItemId(R.id.nav_home);
    }
    public void loadFrag(Fragment fragment, boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction  ft = fm.beginTransaction();
        if (flag==true)
        ft.add(R.id.container1, fragment);
        else
            ft.replace(R.id.container1, fragment);
        ft.commit();
    }
}