package com.example.votingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Voterlogin extends AppCompatActivity {
    Button login;
    EditText voterID,password;
    private DatabaseReference ref;
    String logined_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_voterlogin);
        login = findViewById(R.id.button);

        voterID = findViewById(R.id.id);
        password = findViewById(R.id.pass);

        ref = FirebaseDatabase.getInstance().getReference().child("Votersdb");
        logined_id = voterID.getText().toString();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = voterID.getText().toString();
                String pass = password.getText().toString();
                if(ref.child(ID) != null){
                    ref.child(ID).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Votersdb votersdb = snapshot.getValue(Votersdb.class);
                            if(pass.equals(votersdb.getDob())){
                                Intent log = new Intent(Voterlogin.this,Votebuzzer.class);
                                log.putExtra("Voter_ID",logined_id);
                                startActivity(log);
                            }
                            else{
                                Toast.makeText(Voterlogin.this,"Login Failed...",Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                else{
                    Toast.makeText(Voterlogin.this, "Login Failed...", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}