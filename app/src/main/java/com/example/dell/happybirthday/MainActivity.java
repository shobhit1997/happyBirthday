package com.example.dell.happybirthday;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
CountDownTimer timer;
    CountDownTimer timer1;
MediaPlayer mediaPlayer;
    boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mediaPlayer=MediaPlayer.create(this,R.raw.welcome);
        timer= new CountDownTimer(6000+100, 2000) {
            @Override
            public void onTick(long l) {
                Toast.makeText(getApplicationContext(),"TAP ON HAPPY BIRTHDAY...",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {

                Intent intent = new Intent(getApplicationContext() , Main2Activity.class);

                startActivity(intent);

            }
        };

        timer1= new CountDownTimer(mediaPlayer.getDuration(), 2000) {
            @Override
            public void onTick(long l) {
                Toast.makeText(getApplicationContext(), "WELCOME", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {

                timer.start();
                flag=true;

            }
        };





    }

    @Override
    protected void onResume() {
        super.onResume();

        new CountDownTimer(4000 + 100, 1000) {
            @Override
            public void onTick(long l) {
                Toast.makeText(getApplicationContext(), "TURN ON THE VOLUME..", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {

                mediaPlayer.start();
                timer1.start();

            }
        }.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();
        finish();
    }

    public void change(View view)
    {
        if(flag) {
            timer.cancel();
            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);

            startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
    }

}
