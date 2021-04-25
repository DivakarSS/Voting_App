package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Adminside extends AppCompatActivity {

    ExtendedFloatingActionButton voter,count;
    FloatingActionButton signout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_adminside);

        voter = findViewById(R.id.voter);
        count = findViewById(R.id.count);
        signout = findViewById(R.id.signout);

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signout = new Intent(Adminside.this,Home.class);
                startActivity(signout);
            }
        });

        voter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent votepage = new Intent(Adminside.this,Updatevoter.class);
                startActivity(votepage);
            }
        });

    }
}