package com.example.admin.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class yfh1 extends AppCompatActivity{
    private Button button_forward;
    private DatabaseReference fDatabase;
    private RadioGroup rg1,rg2,rg3;
    private String s1,s2,s3;
    String key;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yfh);
        Intent intent=getIntent();
        key=intent.getStringExtra("id");
        fDatabase = FirebaseDatabase.getInstance().getReference("Patient");
        button_forward=findViewById(R.id.button_forward);
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> yfh = new HashMap<>();
                yfh.put("obesity", s1);
                yfh.put("diabetes", s2);
                yfh.put("high blood pressure", s3);
                fDatabase.child(key).child("Your family Health").updateChildren(yfh);
                Intent intent = new Intent();
                intent.setClass(yfh1.this, com.example.admin.myapplication.yfh2.class);
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
