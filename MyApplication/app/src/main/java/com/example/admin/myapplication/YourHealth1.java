package com.example.admin.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class YourHealth1 extends AppCompatActivity{
    private Button button_forward;
    private DatabaseReference fDatabase;
    private RadioGroup rg1,rg2,rg3;
    private String s1,s2,s3,d1,d2,d3;
    String key;
    private EditText e1,e2,e3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yhealth1);
        Intent intent=getIntent();
        key=intent.getStringExtra("id");
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        fDatabase = FirebaseDatabase.getInstance().getReference("Patient");
        button_forward=findViewById(R.id.button_forward);
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d1 = e1.getText().toString();
                d2 = e2.getText().toString();
                d3 = e3.getText().toString();
                Map<String, Object> yourhealth = new HashMap<>();
                yourhealth.put("diabetes", s1);
                yourhealth.put("when", d1);
                yourhealth.put("high blood pressure", s2);
                yourhealth.put("when", d2);
                yourhealth.put("high cholesterol", s3);
                yourhealth.put("when", d3);
                fDatabase.child(key).child("Your Health").updateChildren(yourhealth);
                Intent intent = new Intent();
                intent.setClass(YourHealth1.this, com.example.admin.myapplication.YourHealth2.class);
                intent.putExtra("id",key);
                startActivity(intent);
            }
        });
        rg1 = (RadioGroup) findViewById(R.id.rg1);
        rg2 = (RadioGroup) findViewById(R.id.rg2);
        rg3 = (RadioGroup) findViewById(R.id.rg3);
        rg1.setOnCheckedChangeListener(listener1);
        rg2.setOnCheckedChangeListener(listener2);
        rg3.setOnCheckedChangeListener(listener3);
    }
    private RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(group.getCheckedRadioButtonId()==R.id.r1) {
                s1 = "No";}
            else{
                s1 = "Yes";
            }
        }
    };
    private RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(group.getCheckedRadioButtonId()==R.id.r3) {
                s2 = "No";}
            else{
                s2 = "Yes";
            }
        }
    };
    private RadioGroup.OnCheckedChangeListener listener3 = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(group.getCheckedRadioButtonId()==R.id.r5) {
                s3 = "No";}
            else{
                s3 = "Yes";
            }
        }
    };
}