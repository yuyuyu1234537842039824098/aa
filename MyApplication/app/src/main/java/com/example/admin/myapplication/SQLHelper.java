package com.example.admin.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SQLHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "patients_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "patientID";
    private static final String COL3 = "birth";
    private static final String COL4 = "phyle";

    //    private static final String COL5="date";
    public SQLHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = " CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT, " + COL3 + " TEXT, " +COL4 + " TEXT)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean addData(String patientID, ArrayList<Location> locations){
        SQLiteDatabase db = this.getWritableDatabase();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String dateToString =simpleDateFormat.format(date);
        long result=-1;
        for(int i=0;i<locations.size();i++){
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL2,patientID);
            contentValues.put(COL3,locations.get(i).getLatitude());
            contentValues.put(COL4,locations.get(i).getLongitude());
//            contentValues.put(COL5,dateToString);
            Log.d(TAG,"addData : Adding "+patientID+" "+locations.get(i).getLatitude()+ " "+
                    locations.get(i).getLongitude()+" "+dateToString+ " to "+TABLE_NAME);
            db.insert(TABLE_NAME,null,contentValues);
            result=0;

        }
        if(result == -1){
            return false;
        }else{
            return true;
        }

    }
    public void update_phyle(String value,int id) {
//        Log.e("DatabaseHelper", "update");

        SQLiteDatabase db = getWritableDatabase(); // 以读写的形式打开数据库
        String sql = "update patients_table set phyle="
                + String.format("'%s'", value)+ " where patientID=" + id;;


//        Log.e("update", sql);
        db.execSQL(sql); // 更新数据库
        db.close(); // 关闭数据库连接
    }



    public String queryPersonById(int _id) {

       String aa = null;
//        Person person = null;
        SQLiteDatabase db = getReadableDatabase(); // 以只读方式打开数据库
//		String[] columns = { "_id", "name", "age" };
        String[] columns = { "ID", "patientID", "birth", "phyle" };
        String selection = "patientID=?";
        String[] selectionArgs = { String.valueOf(_id) };
        Cursor cursor = db.query("patients_table", columns, selection, selectionArgs,
                null, null, null);
        if (cursor.moveToNext()) {
            aa=cursor.getString(cursor.getColumnIndex("phyle"));

        }
        return aa;


//    public Cursor getLatLngPoints (String date){
//        SQLiteDatabase db = this.getWritableDatabase();
//        String query="SELECT * FROM " + TABLE_NAME + " WHERE "+COL5+" = '"+date + "'";
//        Cursor data = db.rawQuery(query, null);
//
//        return data;
//    }

}
}
