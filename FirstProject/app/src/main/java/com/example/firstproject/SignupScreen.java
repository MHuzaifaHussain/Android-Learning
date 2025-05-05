package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SignupScreen extends AppCompatActivity {

    EditText name, email, password, confirmpassword;
    androidx.appcompat.widget.AppCompatButton btnSignup;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
        getSupportActionBar().hide();



        name =findViewById(R.id.etname);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        confirmpassword = findViewById(R.id.etconfirmsignup);
        btnSignup = findViewById(R.id.btnsignup);



    }
}