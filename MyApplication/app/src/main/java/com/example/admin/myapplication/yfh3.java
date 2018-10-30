package com.example.admin.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class yfh3 extends AppCompatActivity{
    private Button button_forward;
    private String isCancer;
    private LinearLayout l1, l2;
    private TextView t1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yfh2);
        Intent intent=getIntent();
        isCancer=intent.getStringExtra("cancer");
        if(isCancer.equals("No")) {
            t1 = findViewById(R.id.t1);
            l1 = findViewById(R.id.l1);
            l2 = findViewById(R.id.l2);
            t1.setVisibility(View.INVISIBLE);
            l1.setVisibility(View.INVISIBLE);
            l2.setVisibility(View.INVISIBLE);

        }
        button_forward=findViewById(R.id.button_forward);
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                birth = (TextView) findViewById(R.id.birth);
//                bir = birth.getText().toString();
//                Map<String, Object> birthUpdate = new HashMap<>();
//                birthUpdate.put("birth", bir);
//                fDatabase.child(key).updateChildren(birthUpdate);
                Intent intent = new Intent();
                intent.setClass(yfh3.this, com.example.admin.myapplication.MainActivity.class);
//                intent.putExtra("cancer",phyle);
                startActivity(intent);
            }
        });
}}