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

public class Aadharauthentication extends AppCompatActivity {

    EditText voter_id,aadhar;
    Button validate;
    private DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadharauthentication);
        getSupportActionBar().hide();

        voter_id = findViewById(R.id.Voter_id);
        aadhar = findViewById(R.id.aadhar);

        validate = findViewById(R.id.button4);

        ref = FirebaseDatabase.getInstance().getReference().child("Votersdb");

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = voter_id.getText().toString();
                String aadharno = aadhar.getText().toString();

                if(ref.child(ID) != null){
                    ref.child(ID).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Votersdb votersdb = snapshot.getValue(Votersdb.class);
                            if(aadharno.equals(votersdb.getAadhar())){

                                Intent log = new Intent(Aadharauthentication.this, Rightindex.class);
                                startActivity(log);

                            }
                            else{
                                Toast.makeText(Aadharauthentication.this,"Login Failed...1",Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                else{
                    Toast.makeText(Aadharauthentication.this, "Login Failed...2", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}