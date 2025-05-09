package com.example.customdialogbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dialog dialog= new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.custom_dialog_layout);
        dialog.setCancelable(false);
        AppCompatButton btnok = dialog.findViewById(R.id.btnok);

        btnok.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Closed", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        dialog.show();
    }
}