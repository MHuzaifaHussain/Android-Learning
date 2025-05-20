package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class LoginActivity2 extends AppCompatActivity {
AppCompatButton btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        btnLogin = findViewById(R.id.btnlogin);
        getSupportActionBar().hide();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code for verification

                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor =pref.edit();


                editor.putBoolean("flag", true);
                editor.apply();

                Intent iHome = new Intent(LoginActivity2.this, HomeActivity.class);
                startActivity(iHome);
            }
        });
    }
}