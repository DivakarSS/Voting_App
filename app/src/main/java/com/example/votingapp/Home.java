package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class Home extends AppCompatActivity {

    ExtendedFloatingActionButton voter,admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        getSupportActionBar().hide();

        voter = findViewById(R.id.voter);
        admin = findViewById(R.id.admin);

        voter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log =new Intent(Home.this,Voterlogin.class);
                startActivity(log);
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log =new Intent(Home.this,Adminloginpage.class);
                startActivity(log);
            }
        });

    }
}