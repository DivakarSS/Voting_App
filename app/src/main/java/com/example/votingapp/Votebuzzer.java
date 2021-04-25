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

        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log = new Intent(Votebuzzer.this,Aadharauthentication.class);
                startActivity(log);
            }
        });
    }
}