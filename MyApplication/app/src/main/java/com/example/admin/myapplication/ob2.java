package com.example.admin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ob2 extends AppCompatActivity {
    private Button button_forward;
    private DatabaseReference fDatabase;
    private EditText e1,e2,e3,e4,e5,e6,e7;
    private String key, date;
    private String total_fat_mass, total_lean_mass, total_body_water, trunk_fat_mass, trunk_lean_mass, peripheral_fat_mass, peripheral_lean_mass;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bobservations2);
        e1= findViewById(R.id.editText1);
        e1.addTextChangedListener(editclick1);
        e2= findViewById(R.id.editText2);
        e2.addTextChangedListener(editclick2);
        e3= findViewById(R.id.editText3);
        e3.addTextChangedListener(editclick3);
        e4= findViewById(R.id.editText4);
        e4.addTextChangedListener(editclick4);
        e5= findViewById(R.id.editText5);
        e5.addTextChangedListener(editclick5);
        e6= findViewById(R.id.editText6);
        e6.addTextChangedListener(editclick6);
        e7= findViewById(R.id.editText7);
        e7.addTextChangedListener(editclick7);
        Intent intent=getIntent();
        key=intent.getStringExtra("id");
        date=intent.getStringExtra("date");
//        key=intent.getStringExtra("id");
//        fDatabase = FirebaseDatabase.getInstance().getReference("Patient");
        fDatabase = FirebaseDatabase.getInstance().getReference("Observations");
        button_forward=findViewById(R.id.button_forward);
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> observation = new HashMap<>();
                observation.put("total_fat_mass", total_fat_mass);
                observation.put("total_lean_mass", total_lean_mass);
                observation.put("total_body_water", total_body_water);
                observation.put("trunk_fat_mass",trunk_fat_mass);
                observation.put("trunk_lean_mass", trunk_lean_mass);
                observation.put("peripheral_fat_mass", peripheral_fat_mass);
                observation.put("test", peripheral_lean_mass);
                fDatabase.child(key).child(date).updateChildren(observation);
                Intent intent = new Intent();
                intent.setClass(ob2.this, com.example.admin.myapplication.MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private TextWatcher editclick1 = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            total_fat_mass = e3.getText().toString();

        }

    };
    private TextWatcher editclick2 = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            total_lean_mass = e3.getText().toString();

        }

    };
    private TextWatcher editclick3 = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            total_body_water = e3.getText().toString();

        }

    };
    private TextWatcher editclick4 = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            trunk_fat_mass = e3.getText().toString();

        }

    };
    private TextWatcher editclick5 = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            trunk_lean_mass = e3.getText().toString();

        }

    };
    private TextWatcher editclick6 = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            peripheral_fat_mass = e3.getText().toString();

        }

    };
    private TextWatcher editclick7 = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            peripheral_lean_mass = e3.getText().toString();

        }

    };

}
