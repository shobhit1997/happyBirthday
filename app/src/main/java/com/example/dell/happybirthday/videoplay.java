package com.example.dell.happybirthday;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Timer;

public class videoplay extends AppCompatActivity {
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplay);
        Intent i=getIntent();
        id=i.getIntExtra("videoID",R.raw.video1);
        VideoView videoView=(VideoView)findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+ id);
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();




    }
    public void next(View view)
    {
        if(id==R.raw.video1) {
            Intent intent = new Intent(getApplicationContext(), slideshow.class);

            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);

            startActivity(intent);
        }


    }
}
