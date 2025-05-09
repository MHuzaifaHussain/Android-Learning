package com.example.customtoastexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btnToast;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnToast = findViewById(R.id.btnToast);

        btnToast.setOnClickListener(v -> {

            Toast toast= new Toast(getApplicationContext());

            View view= getLayoutInflater().inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.viewContainer));
            toast.setView(view);

            TextView txtMsg = view.findViewById(R.id.txtMsg);
            txtMsg.setText("Message Sent Successfully");

            toast.setDuration(Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
            toast.show();
        });




    }
}