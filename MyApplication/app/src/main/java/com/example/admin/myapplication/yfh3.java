package com.example.admin.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class yfh3 extends AppCompatActivity{
    private DatabaseReference fDatabase;
    private RadioGroup  rg1,rg2;
    private Button button_forward;
    private String isCancer;
    private LinearLayout l1, l2;
    private TextView t1;
    private String s1,s2;
    String key;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yfh2);
        Intent intent=getIntent();
        isCancer=intent.getStringExtra("cancer");
        key = intent.getStringExtra("id");
        if(isCancer.equals("No")) {
            t1 = findViewById(R.id.t1);
            l1 = findViewById(R.id.l1);
            l2 = findViewById(R.id.l2);
            t1.setVisibility(View.INVISIBLE);
            l1.setVisibility(View.INVISIBLE);
            l2.setVisibility(View.INVISIBLE);

        }
        fDatabase = FirebaseDatabase.getInstance().getReference("Patient");
        button_forward=findViewById(R.id.button_forward);
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> yfh = new HashMap<>();
                yfh.put("Difficulties conceiving? ", s2);
                yfh.put("Irregular periods", s1);
                fDatabase.child(key).child("Your family Health").updateChildren(yfh);
                Intent intent = new Intent();
                intent.setClass(yfh3.this, com.example.admin.myapplication.MainActivity.class);
//                intent.putExtra("id",key);
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
}