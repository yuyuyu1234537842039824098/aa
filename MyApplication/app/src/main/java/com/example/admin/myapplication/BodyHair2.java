package com.example.admin.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BodyHair2 extends AppCompatActivity{
    private DatabaseReference fDatabase;
    private RadioGroup rg1,rg2, rg3, rg4,rg5;
    private Button button_forward;
    private String s1,s2,s3,s4,s5;
    private String key;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bodyhair2);
        Intent intent=getIntent();
        key = intent.getStringExtra("id");
        fDatabase = FirebaseDatabase.getInstance().getReference("Patient");
        button_forward=findViewById(R.id.button_forward);
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(BodyHair2.this, com.example.admin.myapplication.BodyHair3.class);
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
        rg4 = (RadioGroup) findViewById(R.id.rg4);
        rg5 = (RadioGroup) findViewById(R.id.rg5);
        rg4.setOnCheckedChangeListener(listener4);
        rg5.setOnCheckedChangeListener(listener5);
    }
    private RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {
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
    private RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (group.getCheckedRadioButtonId()){
                case R.id.r1:
                    s3 = "1";
                    break;
                case R.id.r2:
                    s3 = "2";
                    break;
                case R.id.r3:
                    s3 = "3";
                    break;
                case R.id.r4:
                    s3 = "4";
                    break;
            }
        }
    };
    private RadioGroup.OnCheckedChangeListener listener3 = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (group.getCheckedRadioButtonId()){
                case R.id.r9:
                    s3 = "1";
                    break;
                case R.id.r10:
                    s3 = "2";
                    break;
                case R.id.r11:
                    s3 = "3";
                    break;
                case R.id.r12:
                    s3 = "4";
                    break;
            }
        }
    };
    private RadioGroup.OnCheckedChangeListener listener4 = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (group.getCheckedRadioButtonId()){
                case R.id.r13:
                    s3 = "1";
                    break;
                case R.id.r14:
                    s3 = "2";
                    break;
                case R.id.r15:
                    s3 = "3";
                    break;
                case R.id.r16:
                    s3 = "4";
                    break;
            }
        }
    };
    private RadioGroup.OnCheckedChangeListener listener5 = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (group.getCheckedRadioButtonId()){
                case R.id.r17:
                    s3 = "1";
                    break;
                case R.id.r18:
                    s3 = "2";
                    break;
                case R.id.r19:
                    s3 = "3";
                    break;
                case R.id.r20:
                    s3 = "4";
                    break;
            }
        }
    };
}