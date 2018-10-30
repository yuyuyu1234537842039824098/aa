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

public class Bodyhair1 extends AppCompatActivity{
    private DatabaseReference fDatabase;
    private RadioGroup  rg1,rg2, rg3;
    private Button button_forward;
    private String s1,s2,s3;
    private String key;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bodyhair);
        Intent intent=getIntent();
        key = intent.getStringExtra("id");
        fDatabase = FirebaseDatabase.getInstance().getReference("Patient");
        button_forward=findViewById(R.id.button_forward);
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> bh = new HashMap<>();
                bh.put("unwanted loss of your scalp hair", s1);
                bh.put("unwanted body or facial hair growth", s2);
                bh.put("bear", s3);
                fDatabase.child(key).child("Body Hair").updateChildren(bh);
                Intent intent = new Intent();
                intent.setClass(Bodyhair1.this, com.example.admin.myapplication.BodyHair2.class);
                intent.putExtra("id",key);
                startActivity(intent);
            }
        });
        rg3 = (RadioGroup) findViewById(R.id.rg3);
        rg1 = (RadioGroup) findViewById(R.id.rg1);
        rg2 = (RadioGroup) findViewById(R.id.rg2);
        rg3.setOnCheckedChangeListener(listener3);
        rg1.setOnCheckedChangeListener(listener1);
        rg2.setOnCheckedChangeListener(listener2);
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
            switch (group.getCheckedRadioButtonId()){
                case R.id.r5:
                    s3 = "1";
                    break;
                case R.id.r6:
                    s3 = "2";
                    break;
                case R.id.r7:
                    s3 = "3";
                    break;
                case R.id.r8:
                    s3 = "4";
                    break;
            }
        }
    };
}
