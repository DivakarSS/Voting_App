package com.example.votingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Adminloginpage extends AppCompatActivity {

    private EditText Id,dob;
    private Button login;
    Switch active;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_adminloginpage);

        Id = findViewById(R.id.id);
        dob = findViewById(R.id.pass);
        login = findViewById(R.id.login);

        active = findViewById(R.id.active);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                databaseReference.child("Admin").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String id = Id.getText().toString();
                        String password = dob.getText().toString();

                        if(dataSnapshot.child(id).exists()){
                            if (dataSnapshot.child(id).child("password").getValue(String.class).equals(password)){
//                             Preferences.setDataLogin(Adminloginpage.this,true);
//                             Preferences.setDataAs(Adminloginpage.this,"admin");
//                             startActivity(new Intent(Adminloginpage.this,Adminside.class));

                                if(active.isChecked()){
                                    if(dataSnapshot.child(id).child("as").getValue(String.class).equals("admin")){
                                        Preferences.setDataLogin(Adminloginpage.this,true);
                                        Preferences.setDataAs(Adminloginpage.this,"admin");
                                        startActivity(new Intent(Adminloginpage.this,Adminside.class));

                                    }else {
                                        Preferences.setDataLogin(Adminloginpage.this,true);
                                    }
                                }else{
                                    if (dataSnapshot.child(id).child("as").getValue(String.class).equals("admin")) {
                                        Preferences.setDataLogin(Adminloginpage.this, false);
                                        startActivity(new Intent(Adminloginpage.this, Adminside.class));

                                    } else{
                                        Preferences.setDataLogin(Adminloginpage.this,false);
                                    }
                                }

                            }
                            else{
                                Toast.makeText(Adminloginpage.this,"Invalid Entry",Toast.LENGTH_LONG).show();
                            }

                        }
                        else{
                            Toast.makeText(Adminloginpage.this,"Invalid Entry",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });


    }
}