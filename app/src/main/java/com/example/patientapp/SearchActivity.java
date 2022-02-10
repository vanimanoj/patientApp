package com.example.patientapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4,ed5;
AppCompatButton b1;
String getpcode,getpname,getpadd,getmob,getdname;
DbHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ed1=(EditText) findViewById(R.id.mobileno);
        ed2=(EditText) findViewById(R.id.pcode);
        ed3=(EditText) findViewById(R.id.name);
        ed4=(EditText) findViewById(R.id.address);
        ed5=(EditText) findViewById(R.id.drname);
        b1=(AppCompatButton) findViewById(R.id.search);
        mydb=new DbHelper(this);
        mydb.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getpcode=ed1.getText().toString();
                Cursor c=mydb.SearchPatient(getmob);
                if (c.getCount()==0)
                {
                    ed1.setText("");
                    ed2.setText("");
                    ed3.setText("");
                    ed4.setText("");
                    Toast.makeText(getApplicationContext(), "NO RESULT", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while(c.moveToNext())
                    {
                        getpcode=c.getString(1);
                        getpname=c.getString(2);
                        getpadd=c.getString(3);
                        getdname=c.getString(5);
                    }
                    ed3.setText(getpname);
                    ed4.setText(getpadd);
                    ed5.setText(getdname);
                }

                



            }
        });
    }
}