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

public class YourHealth3 extends AppCompatActivity{
    private Button button_forward;
    private DatabaseReference fDatabase;
    private RadioGroup rg1,rg2,rg3;
    private String s1,s2,s3,d1,d2,d3,d4;
    String key;
    private EditText e1,e2,e3,e4;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yhealth3);
        Intent intent=getIntent();
        key=intent.getStringExtra("id");
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);
        fDatabase = FirebaseDatabase.getInstance().getReference("Patient");
        button_forward=findViewById(R.id.button_forward);
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d1 = e1.getText().toString();
                d2 = e2.getText().toString();
                d3 = e3.getText().toString();
                d4 = e4.getText().toString();
                Map<String, Object> yourhealth = new HashMap<>();
                yourhealth.put("blood clot in the deep veins", s1);
                yourhealth.put("when", d1);
                yourhealth.put("smoke", s2);
                yourhealth.put("how many per day", d2);
                yourhealth.put("smoke years", d3);
                yourhealth.put(" drink alcohol", s3);
                yourhealth.put("how many units every week", d4);
                fDatabase.child(key).child("Your Health").updateChildren(yourhealth);
                Intent intent = new Intent();
                intent.setClass(YourHealth3.this, com.example.admin.myapplication.yfh1.class);
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
            switch (group.getCheckedRadioButtonId()) {
                case R.id.r3:
                    s2 ="No, never";
                    break;
                case R.id.r4:
                    s2 ="No, but smoked in the past";
                    break;
                case R.id.r5:
                    s2 ="Yes, still smoking";
                    break;
            }
        }
    };
    private RadioGroup.OnCheckedChangeListener listener3 = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(group.getCheckedRadioButtonId()==R.id.r6) {
                s2 = "No";}
            else{
                s2 = "Yes";
            }
        }
    };
}
