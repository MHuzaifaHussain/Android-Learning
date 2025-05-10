package com.example.permissionrequestor;

import static android.Manifest.permission.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
AppCompatButton btnReq;
private static final int REQ_CODE= 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnReq = findViewById(R.id.btnReq);

        btnReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkPer()){
                    Toast.makeText(MainActivity.this, "Permission Already Granted", Toast.LENGTH_SHORT).show();
                }else {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{ACCESS_FINE_LOCATION, READ_SMS}, REQ_CODE);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode==REQ_CODE){
            if (grantResults.length>0){
                int loc = grantResults[0];
                int msg = grantResults[1];
                boolean checkLoc = loc ==PackageManager.PERMISSION_GRANTED;
                boolean checkMsg = msg == PackageManager.PERMISSION_GRANTED;

                if (checkLoc && checkMsg){
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(this, "Permission Denied!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public boolean checkPer(){
        int resultLoc = ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION);
        int resultMsgRead = ActivityCompat.checkSelfPermission(this, READ_SMS);
        return resultLoc == PackageManager.PERMISSION_GRANTED && resultMsgRead== PackageManager.PERMISSION_GRANTED;
    }
}