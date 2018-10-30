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
    //    private DatabaseReference BDatabse;
    private RadioGroup radioGroup;
    private TextView birth, patient_id;
    private String phyle ="No";
    private Button button_forward;
    private RadioButton r1,r2;
    String key;
//    SQLHelper mDatabaseHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yfh1);
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
//                birth = (TextView) findViewById(R.id.birth);
//                bir = birth.getText().toString();
//                Map<String, Object> birthUpdate = new HashMap<>();
//                birthUpdate.put("birth", bir);
//                fDatabase.child(key).updateChildren(birthUpdate);
                Intent intent = new Intent();
                intent.setClass(yfh2.this, com.example.admin.myapplication.yfh3.class);
                intent.putExtra("cancer",phyle);
                startActivity(intent);
            }
        });
//        r1= findViewById(R.id.r1);
//        r2 = findViewById(R.id.r2);
//        r2.
//        patient_id = (TextView) findViewById(R.id.id);
//        patient_id.setText(key);
//        birth = (TextView) findViewById(R.id.birth);
        radioGroup = (RadioGroup) findViewById(R.id.rg10);
        radioGroup.setOnCheckedChangeListener(listener);
    }




    private RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(group.getCheckedRadioButtonId()==R.id.r1) {
                phyle = "No";}
            else{
                phyle = "Yes";
            }
        }
    };


}
