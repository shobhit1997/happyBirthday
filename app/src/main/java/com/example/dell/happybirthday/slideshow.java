package com.example.dell.happybirthday;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class slideshow extends AppCompatActivity {
    int ar[]={R.drawable.photo1,R.drawable.photo2,R.drawable.photo3,R.drawable.photo4,R.drawable.photo5,R.drawable.photo6,R.drawable.photo7,R.drawable.photo8,R.drawable.photo9,R.drawable.photo10,R.drawable.photo11,R.drawable.photo12,R.drawable.photo13,R.drawable.photo31,R.drawable.photo32,R.drawable.photo33};
    int i=0;
    MediaPlayer mediaPlayer;
    SingleShotImageView imageView;
    boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slideshow);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageView=(SingleShotImageView)findViewById(R.id.slide);
         mediaPlayer=MediaPlayer.create(this,R.raw.birthdaysong2);

        Intent intent=getIntent();





    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
        new CountDownTimer(ar.length*3000+1000, mediaPlayer.getDuration()/ar.length) {
            @Override
            public void onTick(long l) {

                imageView.getDrawable().setCallback(null);

                if(i<ar.length)
                    imageView.setImageResource(ar[i++]);
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "TAP PLEASE", Toast.LENGTH_SHORT).show();
                flag=true;
            }
        }.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        finish();
    }
    public void next(View view)
    {
        if (flag){

            Intent intent = new Intent(getApplicationContext(), Feedback.class);

            startActivity(intent);
        }

    }



}
