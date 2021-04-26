package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Votebuzzer extends AppCompatActivity {

    Button vote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votebuzzer);
        getSupportActionBar().hide();

        vote = findViewById(R.id.button2);
        Intent log = getIntent();
        String Logined_Id = log.getStringExtra("Voter_ID");

        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent log = new Intent(Votebuzzer.this,Aadharauthentication.class);
                log.putExtra("Voter_ID",Logined_Id);
                startActivity(log);
            }
        });
    }
}