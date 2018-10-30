package com.example.admin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class choice extends AppCompatActivity {
    private Button button1, button2,button3;
    private String key;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        Intent intent=getIntent();
        key=intent.getStringExtra("id");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(choice.this, com.example.admin.myapplication.ob1.class);
                intent.putExtra("id",key);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(choice.this, com.example.admin.myapplication.cv1.class);
                intent.putExtra("id",key);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(choice.this, com.example.admin.myapplication.ib.class);
                intent.putExtra("id",key);
                startActivity(intent);
            }
        });
    }
}
