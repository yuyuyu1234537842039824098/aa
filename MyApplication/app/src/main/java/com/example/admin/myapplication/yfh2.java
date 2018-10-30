package com.example.admin.myapplication;

        import android.content.ContentValues;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.app.Notification;
        import android.app.NotificationManager;
        import android.content.Intent;
        import android.view.View;
        import android.widget.Button;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;

        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;
        import com.idescout.sql.SqlScoutServer;

        import java.util.HashMap;
        import java.util.Map;


public class yfh2 extends AppCompatActivity {
    private DatabaseReference fDatabase;
    private RadioGroup radioGroup, rg1,rg2;
    private Button button_forward;
    private String s1,s2,s3;
    String key;
//    SQLHelper mDatabaseHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yfh1);
        Intent intent=getIntent();
        key=intent.getStringExtra("id");
        fDatabase = FirebaseDatabase.getInstance().getReference("Patient");
        button_forward=findViewById(R.id.button_forward);
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Map<String, Object> yfh = new HashMap<>();
                  yfh.put("Fatter liver disease", s2);
                  yfh.put("Cancer", s1);
                  yfh.put("Stroke", s3);
                fDatabase.child(key).child("Your family Health").updateChildren(yfh);
                Intent intent = new Intent();
                intent.setClass(yfh2.this, com.example.admin.myapplication.yfh3.class);
                intent.putExtra("cancer",s1);
                intent.putExtra("id",key);
                startActivity(intent);
            }
        });
        radioGroup = (RadioGroup) findViewById(R.id.rg10);
        rg1 = (RadioGroup) findViewById(R.id.rg30);
        rg2 = (RadioGroup) findViewById(R.id.rg20);
        radioGroup.setOnCheckedChangeListener(listener);
        rg1.setOnCheckedChangeListener(listener1);
        rg2.setOnCheckedChangeListener(listener2);
    }




    private RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(group.getCheckedRadioButtonId()==R.id.r1) {
                s1 = "No";}
            else{
                s1 = "Yes";
            }
        }
    };
    private RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(group.getCheckedRadioButtonId()==R.id.r5) {
                s2 = "No";}
            else{
                s2 = "Yes";
            }
        }
    };
    private RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(group.getCheckedRadioButtonId()==R.id.r3) {
                s3 = "No";}
            else{
                s3 = "Yes";
            }
        }
    };


}
