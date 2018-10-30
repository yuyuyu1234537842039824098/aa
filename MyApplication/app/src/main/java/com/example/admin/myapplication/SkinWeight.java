package com.example.admin.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SkinWeight extends AppCompatActivity{
    private Button button_forward;
    private DatabaseReference fDatabase;
    String key;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skin);
        Intent intent=getIntent();
        key=intent.getStringExtra("id");
        fDatabase = FirebaseDatabase.getInstance().getReference("Patient");
        button_forward=findViewById(R.id.button_forward);
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SkinWeight.this, com.example.admin.myapplication.SleepDepression.class);
                startActivity(intent);
            }
        });
    }
}
