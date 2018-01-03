package com.example.dell.happybirthday;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
CountDownTimer timer;
    MediaPlayer mediaPlayer;
    boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mediaPlayer = MediaPlayer.create(this, R.raw.msg1);
        timer = new CountDownTimer(4000 + 100, 2000) {
            @Override
            public void onTick(long l) {
                Toast.makeText(getApplicationContext(), "TAP ON THE SCREEN", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {

                Intent intent = new Intent(getApplicationContext(), HappyBirthday.class);

                startActivity(intent);

            }
        };



    }

    @Override
    protected void onResume() {
        super.onResume();

        mediaPlayer.start();

        new CountDownTimer(mediaPlayer.getDuration(), 2000) {
            @Override
            public void onTick(long l) {
                Toast.makeText(getApplicationContext(), "HAPPY BIRTHDAY", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {

                timer.start();
                flag=true;

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

    public void change(View view) {
        if(flag) {
            timer.cancel();

            Intent intent = new Intent(getApplicationContext(), HappyBirthday.class);

            startActivity(intent);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
    }
}
