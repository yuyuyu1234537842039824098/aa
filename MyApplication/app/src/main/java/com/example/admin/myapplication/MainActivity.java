package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button button_forward, button1, button2;
    private EditText e1;
    private String patient_id;
    Boolean loginTag = false;
//    String str= "nn";
    String key;
    private DatabaseReference fDatabse;
    private DatabaseReference eDatabse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editText1);
        fDatabse = FirebaseDatabase.getInstance().getReference("Patient");
        key = fDatabse.child("Patient").push().getKey();
//        eDatabse = FirebaseDatabase.getInstance().getReference("Patient").getReference(key);
//        fDatabse.child("Res").setValue("hehe");
//        fDatabse.getReference(key);
//        Map<String, Object> childUpdates = new HashMap<>();
//        childUpdates.put("nn", "aa");
//        fDatabse.child(key).updateChildren(childUpdates);
        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, com.example.admin.myapplication.otherActivity.class);
                intent.putExtra("id",key);
                startActivity(intent);
            }
        });
        button1=findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                patient_id=e1.getText().toString();
                Query query = FirebaseDatabase.getInstance().getReference("Patient").orderByKey().equalTo(patient_id);
                query.addChildEventListener(new ChildEventListener() {

                    public void onChildAdded(DataSnapshot dataSnapshot, String s)
                    {
                        loginTag = true;
                    }
                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {
                    }
                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                if(loginTag==true){
                   Intent intent = new Intent();
                   intent.setClass(MainActivity.this, com.example.admin.myapplication.choice.class);
                   intent.putExtra("id",patient_id);
                   startActivity(intent);}
                else{
                    e1.setText("");
                    Toast toast =Toast.makeText(MainActivity.this, "Wrong patient ID,please input again!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    toast.show();
                }
            }
        });

    }


}
