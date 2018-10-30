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

public class SkinWeight extends AppCompatActivity{
    private Button button_forward;
    private DatabaseReference fDatabase;
    private RadioGroup rg1,rg2;
    private String s1,s2,d1,d2,d3;
    String key;
    private EditText e1,e2,e3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skin);
        Intent intent=getIntent();
        key=intent.getStringExtra("id");
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        fDatabase = FirebaseDatabase.getInstance().getReference("Patient");
        button_forward=findViewById(R.id.button_forward);
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d2 = e2.getText().toString();
                d3 = e3.getText().toString();
                Map<String, Object> skin = new HashMap<>();
                skin.put("Acne", s1);
                skin.put("age", d2);
                fDatabase.child(key).child("Skin").updateChildren(skin);
                Map<String, Object> weight = new HashMap<>();
                skin.put("overweight", s2);
                skin.put("age", d3);
                fDatabase.child(key).child("Weight").updateChildren(weight);
                Intent intent = new Intent();
                intent.setClass(SkinWeight.this, com.example.admin.myapplication.YourHealth1.class);
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
