package com.example.patientapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    static String Dbname="PatientApp.db";
    static String TableName="Patient";
    static String col1="id";
    static String col2="pcode";
    static String col3="pname";
    static String col4="padd";
    static String col5="mob";
    static String col6="dname";

    public DbHelper(Context context) {
        super(context, Dbname,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table "+TableName+"("+col1+" integer primary key autoincrement,"+col2+
                " text,"+col3+" text,"+col4+" text,"+col5+" text,"+col6+")";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="drop table if exists "+TableName;
        db.execSQL(query);
        onCreate(db);


    }
    public boolean insertPatient(String pcode,String pname,String padd,String mob,String dname)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put(col2,pcode);
        content.put(col3,pname);
        content.put(col4,padd);
        content.put(col5,mob);
        content.put(col6,dname);
        long status=db.insert(TableName,null,content);
        if(status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor SearchPatient(String empcode)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="select * from "+TableName+" where "+col5+"="+"'"+empcode+"'";
        Cursor c=db.rawQuery(query,null);
        return c;

    }


}
