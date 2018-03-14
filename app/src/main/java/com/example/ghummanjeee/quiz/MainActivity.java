package com.example.ghummanjeee.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText HStfname, HStdname, Htchfname, HtchLname;
    Button Hnext, HStSave, HtchSave;
    Student Hstd = new Student();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
    }

    private void Init() {
        HStfname = (EditText) findViewById(R.id.Fn);
        HStdname = (EditText) findViewById(R.id.Ln);
        Htchfname = (EditText) findViewById(R.id.fNED);
        HtchLname = (EditText) findViewById(R.id.LSED);
        Hnext = (Button) findViewById(R.id.save);
        HStSave = (Button) findViewById(R.id.sae);
        HtchSave = (Button) findViewById(R.id.nxt);
        Hnext.setOnClickListener(this);
        HStSave.setOnClickListener(this);
        HtchSave.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save:
                Toast.makeText(this, "SuccessFully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sae:
                Toast.makeText(this, "SuccessFully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nxt:
                Hstd.setFName(HStfname.getText().toString());
                Hstd.setLName(HStdname.getText().toString());
                Hstd.setTName(Htchfname.getText().toString());
                Hstd.setTLName(HtchLname.getText().toString());
                Intent in = new Intent(MainActivity.this, Main2Activity.class);
                in.putExtra("std", Hstd);
                startActivity(in);
                break;

        }
    }
}
