package com.example.dialoguebox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Single Button DialogueBox

//        AlertDialog alertDialog= new AlertDialog.Builder(this).create();
//
//        alertDialog.setTitle("Terms and Conditions");
//        alertDialog.setIcon(R.drawable.ic_baseline_info_24);
//        alertDialog.setMessage("Have you read all T&C?");
//
//        alertDialog.setButton(Dialog.BUTTON_NEGATIVE, "Yes,I've read it", new DialogInterface.OnClickListener(){
//
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(MainActivity.this, "Yes, You can proceed now", Toast.LENGTH_SHORT).show();
//            }
//        });
//        alertDialog.show();

        AlertDialog.Builder delDialog = new AlertDialog.Builder(MainActivity.this);
        delDialog.setTitle("Delete");
        delDialog.setIcon(R.drawable.ic_baseline_delete_24);
        delDialog.setMessage("Are you sure want to delete?");
        delDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Item Deleted", Toast.LENGTH_SHORT).show();
            }
        });
        delDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Item Not Deleted", Toast.LENGTH_LONG).show();
            }
        });
        delDialog.show();



    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder exitDialog = new AlertDialog.Builder(this);
        exitDialog.setTitle("Exit");
        exitDialog.setMessage("Are you sure want to delete?");
        exitDialog.setIcon(R.drawable.ic_baseline_delete_24);
        exitDialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Welcome Back!", Toast.LENGTH_SHORT).show();
            }
        });
        exitDialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        });
        exitDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Operation Cancelled!", Toast.LENGTH_SHORT).show();
            }
        });
        exitDialog.show();
    }
}