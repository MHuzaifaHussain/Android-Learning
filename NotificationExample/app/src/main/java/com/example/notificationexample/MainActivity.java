package com.example.notificationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import java.nio.channels.Channel;

public class MainActivity extends AppCompatActivity {
private static final String Channel_ID ="My Channel";
private static final int NOTIFICATION_ID =100;
private static final int REQ_Code =100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.icon,null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;

        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification notification;

        Intent iNotify = new Intent(getApplicationContext(),MainActivity.class);
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi = PendingIntent.getActivity(this, REQ_Code,iNotify, PendingIntent.FLAG_UPDATE_CURRENT);

//        Big Picture Notification.Style
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(((BitmapDrawable)( ResourcesCompat.getDrawable(getResources(),R.drawable.icon,null))).getBitmap())
                .bigLargeIcon(largeIcon)
                .setBigContentTitle("Image sent by Application")
                .setSummaryText("New Message");
//        Inbox Style
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("A")
                .addLine("B")
                .addLine("C")
                .addLine("D")
                .addLine("E")
                .addLine("F")
                .addLine("G")
                .addLine("H")
                .addLine("I")
                .addLine("J")
                .addLine("K")
                .setBigContentTitle("Full Message")
                .setSummaryText("Message from Application");


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
             notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.icon)
                    .setContentText("New Message")
                     .setStyle(inboxStyle)
                     .setContentIntent(pi)
                     .setAutoCancel(false)
                     .setSubText("New Message from Application")
                    .setChannelId(Channel_ID)
                    .build();
             nm.createNotificationChannel(new NotificationChannel(Channel_ID, "New Channel", NotificationManager.IMPORTANCE_HIGH));
        }else {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setAutoCancel(false)
                    .setOngoing(true)
                    .setSmallIcon(R.drawable.icon)
                    .setContentIntent(pi)
                    .setStyle(inboxStyle)
                    .setContentText("New Message")
                    .setSubText("New Message from Application")
                    .build();
        }

        nm.notify(Integer.parseInt(String.valueOf(NOTIFICATION_ID)),notification);
    }
}