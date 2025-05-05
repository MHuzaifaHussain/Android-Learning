package com.example.implicitintent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btnDial, btnShare, btnMessage,btnEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDial = findViewById(R.id.btnDial);
        btnEmail = findViewById(R.id.btnEmail);
        btnMessage = findViewById(R.id.btnMessage);
        btnShare = findViewById(R.id.btnShare);


        btnDial.setOnClickListener(view -> {
            Intent iDial= new Intent(Intent.ACTION_DIAL);
            iDial.setData(Uri.parse("tel: 11112222")); // after Tel We have To  Give space .... ok,Thanks
            startActivity(iDial);
        });
          btnMessage.setOnClickListener(view -> {
              Intent iMsg =  new Intent(Intent.ACTION_SENDTO);
              iMsg.setData(Uri.parse("smsto:"+Uri.encode("11112222")));
              iMsg.putExtra("sms_body", "Please solve this ASAP.");
              startActivity(iMsg);
          });
          btnEmail.setOnClickListener(view -> {
              Intent iEmail = new Intent(Intent.ACTION_SEND);
              iEmail.setType("message/rfc822");
              iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"abc@gmail.com", "xyz@gmail.com"});
              iEmail.putExtra(Intent.EXTRA_SUBJECT, "Queries");
              iEmail.putExtra(Intent.EXTRA_TEXT, "Please solve this ASAP.");
              startActivity(Intent.createChooser(iEmail, "Email via"));
          });
          btnShare.setOnClickListener(view -> {
              Intent iShare = new Intent(Intent.ACTION_SEND);
              iShare.setType("text/plain");
              iShare.putExtra(Intent.EXTRA_TEXT, "Download this Amazing App. https://play.google.com/store/details?id=comcubetech");
              startActivity(Intent.createChooser(iShare,"Share Via"));
          });
    }
}