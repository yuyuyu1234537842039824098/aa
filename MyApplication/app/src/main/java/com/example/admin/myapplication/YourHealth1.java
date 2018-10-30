package com.example.admin.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class YourHealth1 extends AppCompatActivity{
    private Button button_forward;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yhealth1);
        button_forward=findViewById(R.id.button_forward);
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(YourHealth1.this, com.example.admin.myapplication.YourHealth2.class);
                startActivity(intent);
            }
        });
    }
}