package com.example.admin.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Map;

public class SleepDepression extends AppCompatActivity{
    private Button button_forward;
    private DatabaseReference fDatabase;
    private RadioGroup rg1,rg2;
    private String s1,s2;
    String key;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleep);
        Intent intent=getIntent();
        key=intent.getStringExtra("id");
        button_forward=findViewById(R.id.button_forward);
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> sleep = new HashMap<>();
                sleep.put("Sleep", s1);
                fDatabase.child(key).updateChildren(sleep);
                Map<String, Object> depression = new HashMap<>();
                depression.put("depression", s2);
                fDatabase.child(key).updateChildren(depression);
                Intent intent = new Intent();
                intent.setClass(SleepDepression.this, com.example.admin.myapplication.YourHealth1.class);
                intent.putExtra("id",key);
                startActivity(intent);
            }
        });
        rg1 = (RadioGroup) findViewById(R.id.rg1);
        rg2 = (RadioGroup) findViewById(R.id.rg2);
        rg1.setOnCheckedChangeListener(listener1);
        rg2.setOnCheckedChangeListener(listener2);
    }
    private RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (group.getCheckedRadioButtonId()){
                case R.id.r1:
                    s1 = "No";
                    break;
                case R.id.r2:
                    s1 = "Yes";
                    break;
                case R.id.r3:
                    s1 = "Don't know";
                    break;

            }
        }
    };
    private RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (group.getCheckedRadioButtonId()){
                case R.id.r4:
                    s2 = "No";
                    break;
                case R.id.r5:
                    s2 = "Yes, most of times";
                    break;
                case R.id.r6:
                    s2 = "Yes, sometimes";
                    break;
                case R.id.r7:
                    s2 = "Don't know";
                    break;

            }
        }
    };
}