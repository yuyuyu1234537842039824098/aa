package com.example.admin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class cv3 extends AppCompatActivity {
    private Button button_forward;
    private String key, date;
    private DatabaseReference fDatabase;
    //    private EditText e1,e2,e3;
    private CheckBox c1,c2,c3,c4,c5,c6;
    private String s1,s2,s3,s4,s5,s6,s7,s8,s9;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clinicreview3);
        c1 = findViewById(R.id.checkBox1);
        c2 = findViewById(R.id.checkBox2);
        c3 = findViewById(R.id.checkBox3);
        c4 = findViewById(R.id.checkBox4);
        c5 = findViewById(R.id.checkBox5);
        c6 = findViewById(R.id.checkBox6);
        Intent intent=getIntent();
        key=intent.getStringExtra("id");
        date = intent.getStringExtra("date");
        fDatabase = FirebaseDatabase.getInstance().getReference("Clinic Review");
        button_forward = findViewById(R.id.button_forward);
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuffer buff = new StringBuffer();
                if(c1.isChecked()){
                    buff.append(c1.getText());
                    buff.append("/");}
                if(c2.isChecked()){
                    buff.append(c2.getText());
                    buff.append("/");}
                if(c3.isChecked()){
                    buff.append(c3.getText());
                    buff.append("/");}
                if(c4.isChecked()){
                    buff.append(c4.getText());
                    buff.append("/");}
                if(c5.isChecked()){
                    buff.append(c5.getText());
                    buff.append("/");}
                if(c6.isChecked()){
                    buff.append(c6.getText());
                    buff.append("/");}
                String bb = buff.toString();
                Map<String, Object> cv = new HashMap<>();
//                cv.put("Date of assessment", mm);
                cv.put("Reasons for referral (according to Patient):", bb);
//                observation.put("test", m7);
                fDatabase.child(key).child(date).updateChildren(cv);
                Intent intent = new Intent();
                intent.setClass(cv3.this, com.example.admin.myapplication.cv4.class);
                intent.putExtra("id",key);
                intent.putExtra("date",date);
                startActivity(intent);
            }
        });
    }
}
