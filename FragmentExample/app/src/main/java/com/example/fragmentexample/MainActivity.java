package com.example.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
AppCompatButton btnFragA, btnFragB,btnFragC;
    private String ROOT_FRAGMENT_TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragA = findViewById(R.id.btnFragA);
        btnFragB = findViewById(R.id.btnFragB);
        btnFragC = findViewById(R.id.btnFragC);

        loadFrag(new BFragment(),0);


        btnFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.loadFrag(new AFragment(), 1);
            }
        });
         btnFragB.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 MainActivity.this.loadFrag(new BFragment(), 1);
             }
         });
         btnFragC.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 MainActivity.this.loadFrag(new CFragment(), 1);
             }
         });
    }
public void loadFrag(Fragment fragment, int flag){
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    Bundle bundle = new Bundle();
    bundle.putString("Arg1", "Huzaifa");
    bundle.putInt("Arg2",7);

    fragment.setArguments(bundle);

    if (flag == 0) {
        ft.add(R.id.container, fragment);
        fm.popBackStack(ROOT_FRAGMENT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        ft.addToBackStack(ROOT_FRAGMENT_TAG);
    }
    else
        ft.replace(R.id.container, fragment);
    ft.addToBackStack(null);
    ft.commit();

}
}