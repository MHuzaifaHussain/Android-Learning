package com.example.audioplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
AppCompatButton btnPlay,btnPause,btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay =findViewById(R.id.btnPlay);
        btnPause =findViewById(R.id.btnPause);
        btnStop =findViewById(R.id.btnStop);

        MediaPlayer mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

//      Audio Path
        String aPath = "android.resource://"+getPackageName()+"/raw/song";
        Uri audioURI= Uri.parse(aPath);

        try {
            mp.setDataSource(this, audioURI);
            mp.prepare();

        } catch (IOException e) {
            e.printStackTrace();
        }

       btnPause.setOnClickListener(view -> mp.pause());

        btnPlay.setOnClickListener(view -> mp.start());

        btnStop.setOnClickListener(view -> {
            mp.pause();
            mp.seekTo(0);

        });
        //mp.seekTo;
        //mp.getDuration();
        //mp.getCurrentPosition();

//        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//                //it is used when a audio file is completed, and like you want to start it again or move to next;
//            }
//        });

    }
}