package com.example.dell.happybirthday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedback extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("feedback");

    }
    public void save(View view)
    {
        EditText txt=(EditText)findViewById(R.id.feedback);

        databaseReference.push().setValue(String.valueOf(txt.getText()));
        txt.clearComposingText();

        Intent intent = new Intent(getApplicationContext() , videoplay.class);
        intent.putExtra("videoID",R.raw.video2);
        startActivity(intent);
    }


}
