package com.example.ghummanjeee.quiz;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class Main3Activity extends AppCompatActivity {
    TextView Hsdfname, Hsdlname, Htfname, Htlname;
    Student Hstd = null;
      ImageView vl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Hsdfname = (TextView) findViewById(R.id.fstsfnal);
        Hsdlname = (TextView) findViewById(R.id.LST);
        Htfname = (TextView) findViewById(R.id.fstchr);
        Htlname = (TextView) findViewById(R.id.LSTc);
        //Hstd = new Student();
        Bundle extras = getIntent().getExtras();
        Hstd = (Student) extras.getSerializable("Std");

        //Intent intent = getIntent();
        vl=(ImageView)findViewById(R.id.tchrimg);
        //    Bitmap bitmap = (Bitmap) intent.getParcelableExtra("Image");
       // vl.setImageBitmap(Hstd.getSImage());


        Hsdfname.setText(Hstd.getFName());
        Hsdlname.setText(Hstd.getLName());
        Htfname.setText(Hstd.getTName());
        Htlname.setText(Hstd.getTLName());
    }


}
