package com.example.dell.happybirthday;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HappyBirthday extends AppCompatActivity {

    boolean flag=false;
    String ar[]={"SO..SINCE THIS YEAR I CANT GET YOU A REAL CAKE..SO THIS IS A SPECIAL ONE FROM MY SIDE..SOME PROMISES ARE MEANT TO BE KEPT..","PLEASE..TAP THE CAKE TO CUT...","WELL..NOW TAP IT AGAIN YOUR YOUR SLICE..","HAPPY BIRTHDAY SWEETHEART..TAP AGAIN.."};
    int i=0;
    MediaPlayer mediaPlayer[]=new MediaPlayer[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happy_birthday);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i=getIntent();

        mediaPlayer[0]=MediaPlayer.create(this,R.raw.birthdaysong);
        mediaPlayer[1]=MediaPlayer.create(this,R.raw.msg2);
        mediaPlayer[2]=MediaPlayer.create(this,R.raw.msg3);
        mediaPlayer[3]=MediaPlayer.create(this,R.raw.msg4);
        mediaPlayer[4]=MediaPlayer.create(this,R.raw.msg5);


    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer[0].start();
        new CountDownTimer(32000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                message();

            }
        }.start();






    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer[0].stop();
        mediaPlayer[0].release();
        mediaPlayer[1].release();
        mediaPlayer[2].release();
        mediaPlayer[3].release();
        mediaPlayer[4].release();
        finish();
    }

    public void message()
    {

        TextView msg=(TextView)findViewById(R.id.message);
        msg.setText("");
        final int length=ar[i].length();
        mediaPlayer[0].pause();
        int duration=mediaPlayer[i+1].getDuration();
        mediaPlayer[i+1].start();

        new CountDownTimer(duration + 100, duration / length) {
            int c=0;
            @Override
            public void onTick(long l) {
                TextView msg=(TextView)findViewById(R.id.message);
                if(c<length) {
                    char cha = ar[i].charAt(c++);

                    msg.append(cha + "");
                }
            }

            @Override
            public void onFinish() {
                flag=true;
                mediaPlayer[i+1].stop();
                mediaPlayer[0].start();
                if(i==0)
                {
                    i=1;
                    message();
                    flag=false;
                }


            }
        }.start();
    }
    public void change(View view) {

        if(flag)
        {
            flag=false;
        int id = view.getId();
        Log.i("id:",id+"");
        if (id == R.id.cake) {

            Log.i("id:","cake");
            final ImageView cake = (ImageView) findViewById(R.id.cake);

            cake.animate().alpha(0f).setDuration(2000);
            ImageView cakecut = (ImageView) findViewById(R.id.cakecut);
            cakecut.setVisibility(View.VISIBLE);


            cakecut.animate().alpha(1.0f).setDuration(2000);
            new CountDownTimer(2000+100,500) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    cake.setVisibility(View.GONE);
                    i=2;

                    message();

                }
            }.start();

        }
        else if (id == R.id.cakecut) {
            Log.i("id:","cakecut");
            final ImageView cakecut = (ImageView) findViewById(R.id.cakecut);
            cakecut.animate().alpha(0.0f).setDuration(2000);
            ImageView slice = (ImageView) findViewById(R.id.slice);
            slice.setVisibility(View.VISIBLE);
            slice.animate().alpha(1.0f).setDuration(2000);
            new CountDownTimer(2000+100,500) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    cakecut.setVisibility(View.GONE);
                    i=3;

                    message();

                }
            }.start();
        }
       else if (id == R.id.slice) {
            Log.i("id:","slice");
            Intent intent = new Intent(getApplicationContext() , videoplay.class);
            intent.putExtra("videoID",R.raw.video1);
            startActivity(intent);

            /*final ImageView slice = (ImageView) findViewById(R.id.slice);
            slice.animate().alpha(0.0f).setDuration(2000);
            ImageView cake = (ImageView) findViewById(R.id.cake);
            cake.setVisibility(View.VISIBLE);
            cake.animate().alpha(1.0f).setDuration(2000);
            new CountDownTimer(2000+100,500) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {

                }
            }.start();*/

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
    }


}
