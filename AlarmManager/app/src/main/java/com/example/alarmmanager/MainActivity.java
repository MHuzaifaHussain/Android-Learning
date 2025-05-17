package com.example.alarmmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtText;
    AppCompatButton btnSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final  int ALARM_REQ= 100;

        btnSet= findViewById(R.id.btnSet);
        edtText =findViewById(R.id.edtTime);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int time = Integer.parseInt(edtText.getText().toString());
                long triggerTime = System.currentTimeMillis()+(time*1000);

                Intent iBroadCast = new Intent(MainActivity.this,MyReceiver.class);
                PendingIntent pi= PendingIntent.getBroadcast(MainActivity.this, ALARM_REQ, iBroadCast, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime, pi);
            }
        });
    }
}