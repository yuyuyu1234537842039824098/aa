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


public class otherActivity extends AppCompatActivity {
    private DatabaseReference fDatabase;
//    private DatabaseReference BDatabse;
    private RadioGroup radioGroup;
    private TextView birth, patient_id;
    private String phyle,bir;
    private Button button_forward;
    String key;
//    SQLHelper mDatabaseHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
//        fDatabse = FirebaseDatabase.getInstance().getReference("Birth");
//        fDatabse.setValue("nn");
//        BDatabse = FirebaseDatabase.getInstance().getReference("Bi");
//        BDatabse.setValue(phyle);
//        mDatabaseHelper=new SQLHelper(this);
//        SQLiteDatabase database = mDatabaseHelper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("patientID", 12);
//        database.insert("patients_table",null,values);
//        values.clear();
        Intent intent=getIntent();
        key=intent.getStringExtra("id");
        fDatabase = FirebaseDatabase.getInstance().getReference("Patient");
        button_forward=findViewById(R.id.button_forward);
        button_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                birth = (TextView) findViewById(R.id.birth);
                bir = birth.getText().toString();
                Map<String, Object> birthUpdate = new HashMap<>();
                birthUpdate.put("birth", bir);
                fDatabase.child(key).updateChildren(birthUpdate);
                Intent intent = new Intent();
                intent.setClass(otherActivity.this, com.example.admin.myapplication.MenstrualCycle.class);
                intent.putExtra("id",key);
                startActivity(intent);
            }
        });
        patient_id = (TextView) findViewById(R.id.id);
        patient_id.setText(key);
//        birth = (TextView) findViewById(R.id.birth);
        radioGroup = (RadioGroup) findViewById(R.id.r1);
        radioGroup.setOnCheckedChangeListener(listener);
    }




    private RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (group.getCheckedRadioButtonId()) {
                case R.id.r2:
                    phyle = "White - British";
                    Map<String, Object> phyleUpdate2 = new HashMap<>();
                    phyleUpdate2 .put("Phyle", phyle);
                    fDatabase.child(key).updateChildren(phyleUpdate2);
//                    mDatabaseHelper.update("phyle","White - British",12);
                    break;
                case R.id.r3:
                    phyle = "White - Irish";
                    Map<String, Object> phyleUpdate3 = new HashMap<>();
                    phyleUpdate3 .put("Phyle", phyle);
                    fDatabase.child(key).updateChildren(phyleUpdate3);
//                    mDatabaseHelper.update("phyle","White - Irish",12);
                    break;
                case R.id.r4:
                    phyle = "Other white background";
//                    mDatabaseHelper.update("phyle",phyle,12);
                    Map<String, Object> phyleUpdate4 = new HashMap<>();
                    phyleUpdate4.put("Phyle", phyle);
                    fDatabase.child(key).updateChildren(phyleUpdate4);
                    break;
                case R.id.r5:
                    phyle = "Black or Black British-Carribean";
                    Map<String, Object> phyleUpdate5 = new HashMap<>();
                    phyleUpdate5.put("Phyle", phyle);
                    fDatabase.child(key).updateChildren(phyleUpdate5);
//                    mDatabaseHelper.update("phyle",phyle,12);
                    break;
                case R.id.r6:
                    phyle = "Black or Black British-African";
                    Map<String, Object> phyleUpdate6 = new HashMap<>();
                    phyleUpdate6.put("Phyle", phyle);
                    fDatabase.child(key).updateChildren(phyleUpdate6);
//                  Map<String, Object> phyleUpdate4 = new HashMap<>();
//                  phyleUpdate4.put("Phyle", phyle);
//                  fDatabase.child(key).updateChildren(phyleUpdate4);
                    break;
                case R.id.r7:
                    phyle = "Other Black Backgroun";
                    Map<String, Object> phyleUpdate7 = new HashMap<>();
                    phyleUpdate7.put("Phyle", phyle);
                    fDatabase.child(key).updateChildren(phyleUpdate7);
//                    mDatabaseHelper.update("phyle",phyle,12);
                    break;
                case R.id.r8:
                    phyle = "Asian or Asian British-Indian";
                    Map<String, Object> phyleUpdate8 = new HashMap<>();
                    phyleUpdate8.put("Phyle", phyle);
                    fDatabase.child(key).updateChildren(phyleUpdate8);
//                    mDatabaseHelper.update("phyle",phyle,12);
                    break;
                case R.id.r9:
                    phyle = "Asian or Asian British-Pakistani";
                    Map<String, Object> phyleUpdate9 = new HashMap<>();
                    phyleUpdate9.put("Phyle", phyle);
                    fDatabase.child(key).updateChildren(phyleUpdate9);
//                    mDatabaseHelper.update("phyle",phyle,12);
                    break;
                case R.id.r10:
                    phyle = "Asian or Asian British-Bangladeshi";
                    Map<String, Object> phyleUpdate10 = new HashMap<>();
                    phyleUpdate10.put("Phyle", phyle);
                    fDatabase.child(key).updateChildren(phyleUpdate10);
//                    mDatabaseHelper.update("phyle",phyle,12);
                    break;
                case R.id.r11:
                    phyle = "Chinese";
                    Map<String, Object> phyleUpdate11 = new HashMap<>();
                    phyleUpdate11.put("Phyle", phyle);
                    fDatabase.child(key).updateChildren(phyleUpdate11);
//                    mDatabaseHelper.update("phyle",phyle,12);
                    break;
                case R.id.r12:
                    phyle = "Mixed – White and Black Carribean";
                    Map<String, Object> phyleUpdate12 = new HashMap<>();
                    phyleUpdate12.put("Phyle", phyle);
                    fDatabase.child(key).updateChildren(phyleUpdate12);
//                    mDatabaseHelper.update("phyle",phyle,12);
                    break;
                case R.id.r13:
                    phyle = "White and Black-African";
                    Map<String, Object> phyleUpdate13 = new HashMap<>();
                    phyleUpdate13.put("Phyle", phyle);
                    fDatabase.child(key).updateChildren(phyleUpdate13);
//                    mDatabaseHelper.update("phyle",phyle,12);
                    break;
                case R.id.r14:
                    phyle = "Other Asian Background";
                    Map<String, Object> phyleUpdate14 = new HashMap<>();
                    phyleUpdate14.put("Phyle", phyle);
                    fDatabase.child(key).updateChildren(phyleUpdate14);
//                    mDatabaseHelper.update("phyle",phyle,12);
                    break;
                case R.id.r15:
                    phyle = "Other Mixed Background";
                    Map<String, Object> phyleUpdate15 = new HashMap<>();
                    phyleUpdate15.put("Phyle", phyle);
                    fDatabase.child(key).updateChildren(phyleUpdate15);
//                    mDatabaseHelper.update("phyle",phyle,12);
                    break;
                case R.id.r16:
                    phyle = "Other Ethic background";
                    Map<String, Object> phyleUpdate16 = new HashMap<>();
                    phyleUpdate16.put("Phyle", phyle);
                    fDatabase.child(key).updateChildren(phyleUpdate16);
//                    mDatabaseHelper.update("phyle",phyle,12);
                    break;
                case R.id.r17:
                    phyle = "Not Known";
                    Map<String, Object> phyleUpdate17 = new HashMap<>();
                    phyleUpdate17.put("Phyle", phyle);
                    fDatabase.child(key).updateChildren(phyleUpdate17);
//                    mDatabaseHelper.update("phyle",phyle,12);
                    break;
                case R.id.r18:
                    phyle = "Information refused";
                    Map<String, Object> phyleUpdate18 = new HashMap<>();
                    phyleUpdate18.put("Phyle", phyle);
                    fDatabase.child(key).updateChildren(phyleUpdate18);
//                    mDatabaseHelper.update("phyle",phyle,12);
                    break;
            }
        }
    };


}


