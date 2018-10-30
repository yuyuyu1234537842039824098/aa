package com.example.admin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ob1 extends AppCompatActivity {
    private Button button_forward;
    private DatabaseReference fDatabase;
    private DatabaseReference pDatabase;
    private EditText e1,e2,e3,e4,e5,e6,e7;
    private String m1,m2,m3,m4,m5,m6;
//    private String m7 = "ipo";
    private TextView BMI;
    private String height,weight;
    private double w;
    private double h;
    String key;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bobservations);
        e1= findViewById(R.id.e1);
        e4= findViewById(R.id.e4);
        e5= findViewById(R.id.e5);
        e6= findViewById(R.id.e6);
        e7= findViewById(R.id.e7);
        e2= findViewById(R.id.e2);
        e2.addTextChangedListener(editclick1);
        e3= findViewById(R.id.e3);
        e3.addTextChangedListener(editclick2);
        BMI= findViewById(R.id.BMI);
        Intent intent=getIntent();
        key=intent.getStringExtra("id");
        fDatabase = FirebaseDatabase.getInstance().getReference("Observations");
        button_forward=findViewById(R.id.button_forward);
        button_forward.setOnClickListener(new View.OnClickListener() {
//            query = pDatabase.orderByKey().equalTo(key);
            @Override
            public void onClick(View v) {

                m1 = e1.getText().toString();
                m2 = e6.getText().toString();
                m3 = e7.getText().toString();
                m4 = e4.getText().toString();
                m5 = e5.getText().toString();
                m6 = BMI.getText().toString();
                StringBuffer buf = new StringBuffer();
                buf.append(m1);
                buf.append("/");
                buf.append(m2);
                buf.append("/");
                buf.append(m3);
                String mm = buf.toString();
//                Query query = pDatabase.orderByKey().equalTo(key);
                Map<String, Object> observation = new HashMap<>();
                observation.put("Date of assessment", mm);
                observation.put("1st blood pressure", m4);
                observation.put("2st blood pressure", m5);
                observation.put("Height",height);
                observation.put("weight", weight);
                observation.put("BMI", m6);
//                observation.put("test", m7);
                fDatabase.child(key).child(mm).updateChildren(observation);
                Intent intent = new Intent();
                intent.setClass(ob1.this, ob2.class);
                intent.putExtra("id",key);
                intent.putExtra("date",mm);
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
            height = (e2.getText()).toString();
            if(!height.equals("")) {
                h = Double.parseDouble(height);
            }
            else{
                h = 0.00;
            }
            DecimalFormat nf = new DecimalFormat("0.00");
            double b = w/(h*h/10000);
            BMI.setText(nf.format(b));
}

};
    private TextWatcher editclick2 = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            weight = e3.getText().toString();
            if(!weight.equals("")) {
                w = Double.parseDouble(weight);
            }
            else{
                w = 0.00;
            }
            DecimalFormat nf = new DecimalFormat("0.00");
            double b = w/(h*h/10000);
            BMI.setText(nf.format(b));
        }

    };
}
