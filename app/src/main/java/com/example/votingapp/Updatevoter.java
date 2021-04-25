package com.example.votingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Updatevoter extends AppCompatActivity {

    EditText name,aadhar,voterid,dob,address,phone;

    Button update;
    FirebaseDatabase database;
    DatabaseReference ref;
    private  Votersdb votersdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatevoter);
        getSupportActionBar().hide();

        name = findViewById(R.id.Name);
        aadhar = findViewById(R.id.aadhar);
        voterid = findViewById(R.id.Voter_id);
        dob = findViewById(R.id.Dob);
        address = findViewById(R.id.Address);
        phone = findViewById(R.id.phone);

        update = findViewById(R.id.button4);
        votersdb = new Votersdb();

        database = FirebaseDatabase.getInstance();
        ref = database.getReference().child("Votersdb");

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                votersdb.setVoterID(voterid.getText().toString());
                votersdb.setAadhar(aadhar.getText().toString());
                votersdb.setName(name.getText().toString());
                votersdb.setDob(dob.getText().toString());
                votersdb.setAddress(address.getText().toString());
                votersdb.setPhone(phone.getText().toString());

                ref.child(votersdb.getVoterID()).setValue(votersdb).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Updatevoter.this,"Updated Successful",Toast.LENGTH_LONG).show();
                            Intent log = new Intent(Updatevoter.this,Adminside.class);
                            startActivity(log);
                        }
                        else{
                            Toast.makeText(Updatevoter.this,"Failed....",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}