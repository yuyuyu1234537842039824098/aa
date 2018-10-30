package com.example.admin.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MenstrualCycle extends AppCompatActivity {
    private Button button_forward;
    private DatabaseReference fDatabase;
    private String regular, first_public_hair = "aa";
    String key;
    private RadioGroup radioGroup1,radioGroup2;
//    SQLHelper mDatabaseHelper;
    private EditText e1,e2,e3,e4,e5;
    private String m1,m2,m3,m4,m5;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menstrualcycle);
        Intent intent=getIntent();
        key=intent.getStringExtra("id");
        fDatabase = FirebaseDatabase.getInstance().getReference("Patient");
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        e4 = (EditText) findViewById(R.id.e4);
        e5 = (EditText) findViewById(R.id.e5);

//        mDatabaseHelper=new SQLHelper(this);
//        e1 = (EditText) findViewById(R.id.e1);
//        e1.setText(mDatabaseHelper.queryPersonById(12));

//        SQLiteDatabase database = mDatabaseHelper.getWritableDatabase();
        button_forward=findViewById(R.id.button_forward);
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m1 = e1.getText().toString();
                m2 = e2.getText().toString();
                m3 = e3.getText().toString();
                m4 = e4.getText().toString();
                m5 = e5.getText().toString();
                Map<String, Object> menstrualcycle = new HashMap<>();
                menstrualcycle.put("First menstrualcycle year", m1);
                menstrualcycle.put("first_public_hair under 8 years old", first_public_hair);
                menstrualcycle.put("if current bleed regular", regular);
                menstrualcycle.put("Average time between two bleed", m2);
                menstrualcycle.put("Bleed number in last 7 months", m3);
                menstrualcycle.put("Irregular year", m4);
                menstrualcycle.put("Last bleed Time", m5);
                fDatabase.child(key).child("Mentrualcycle").updateChildren(menstrualcycle);
                Intent intent = new Intent();
                intent.setClass(MenstrualCycle.this, com.example.admin.myapplication.Bodyhair1.class);
                intent.putExtra("id",key);
                startActivity(intent);
            }
        });
        radioGroup1 = (RadioGroup) findViewById(R.id.rg1);
        radioGroup1.setOnCheckedChangeListener(listener1);
        radioGroup2 = (RadioGroup) findViewById(R.id.rg2);
        radioGroup2.setOnCheckedChangeListener(listener2);

    }
    private RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (group.getCheckedRadioButtonId()) {
                case R.id.r1:
                    first_public_hair = "No";
                    break;
                case R.id.r2:
                    first_public_hair = "Yes";
                    break;

            }
        }
    };
    private RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (group.getCheckedRadioButtonId()) {
                case R.id.r3:
                    regular = "regular";
                    break;
                case R.id.r4:
                    regular = "irregular";
                    break;
                case R.id.r5:
                    regular = "absent";
                    break;

            }
        }
    };
}
