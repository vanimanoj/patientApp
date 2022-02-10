package com.example.patientapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddpatientActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4,ed5;
AppCompatButton b1;
String getpcode,getpname,getadd,getmob,getdname;
DbHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpatient);
        ed1=(EditText) findViewById(R.id.pcode);
        ed2=(EditText) findViewById(R.id.name);
        ed3=(EditText) findViewById(R.id.address);
        ed4=(EditText) findViewById(R.id.mobileno);
        ed5=(EditText) findViewById(R.id.drname);
        b1=(AppCompatButton)findViewById(R.id.submit);
        mydb=new DbHelper(this);
        mydb.getWritableDatabase();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getpcode=ed1.getText().toString();
                getpname=ed2.getText().toString();
                getadd=ed3.getText().toString();
                getmob=ed4.getText().toString();
                getdname=ed5.getText().toString();
                boolean status=mydb.insertPatient(getpcode,getpname,getadd,getmob,getdname);
                if (status == true)
                {

                    Toast.makeText(getApplicationContext(), "Succesfully Inserted", Toast.LENGTH_SHORT).show();
                } else
                {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }


            }
        });



    }
}