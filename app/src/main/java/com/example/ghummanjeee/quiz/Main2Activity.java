package com.example.ghummanjeee.quiz;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    Button HStdSave, HtchSave, Hnext;
    CheckBox Handriod, Hweb;
    ImageView HStdIv;
    ImageView Hchimage;
    Student Hstde = null;
    RatingBar br;
    private TextView rating;
    Integer REQUEST_CAMERA = 0, SELCT_FILE = 1;
    boolean IMAGE_FLAG=false;
    boolean CH_IMAGE_FLAG=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        Hstde = new Student();
        Bundle extras = getIntent().getExtras();
        Hstde = (Student) extras.getSerializable("std");
        HStdSave = (Button) findViewById(R.id.save);
        HtchSave = (Button) findViewById(R.id.sae);
        Handriod = (CheckBox) findViewById(R.id.Andriod);
        Hweb = (CheckBox) findViewById(R.id.web);
        HStdIv = (ImageView) findViewById(R.id.image);
        Hchimage = (ImageView) findViewById(R.id.tchrimg);
        Hnext = (Button) findViewById(R.id.next);
        br = (RatingBar) findViewById(R.id.rtbr);
        Hnext.setOnClickListener(this);
        HStdIv.setOnClickListener(this);
        Hchimage.setOnClickListener(this);
        HStdSave.setOnClickListener(this);
//        HtchSave.setOnClickListener(this);

        rating = (TextView) findViewById(R.id.txt);
        rating.setText(String.valueOf(br.getRating()));

        br.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rat,
                                        boolean fromUser) {
                rating.setText(String.valueOf(rat));
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next:

                Intent in = new Intent(Main2Activity.this, Main3Activity.class);
                in.putExtra("Std", Hstde);
                startActivity(in);
                //Send();
                break;
            case R.id.image:
                IMAGE_FLAG=true;
                select();
                break;
            case R.id.tchrimg:
                CH_IMAGE_FLAG=true;
                select();
                break;
            case R.id.sae:
                if (Handriod.isChecked()) {
                }
                if (Hweb.isChecked()) {

                }

                break;

        }
    }

//    private void Send() {
//        Intent intent = new Intent(this, Main3Activity.class);
//        intent.putExtra("Image", bs.toByteArray());
//        startActivity(intent);
//    }

    private void select() {
        final CharSequence[] items = {"Camera", "Gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ADD IMAGE");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (items[i].equals("Camera")) {
                    Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(it, REQUEST_CAMERA);
                } else if (items[i].equals("Gallery")) {
                    Intent it = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    it.setType("image/*");
                    startActivityForResult(it.createChooser(it, "Select File"), SELCT_FILE);
                }
            }
        });
        builder.show();

    }

    @Override
    public void onActivityResult(int requestcode, int resultcode, Intent data) {
        super.onActivityResult(requestcode, resultcode, data);
        if (resultcode == Activity.RESULT_OK) {

            if (requestcode == REQUEST_CAMERA) {

                Bundle bundle = data.getExtras();
                if (bundle != null) {
                   Bitmap btm = (Bitmap) bundle.get("data");
                    if (IMAGE_FLAG){
                        HStdIv.setImageBitmap(btm);
                       Hstde.setSImage(btm);
                    }else
                    if (CH_IMAGE_FLAG) {
                        Hchimage.setImageBitmap(btm);
                       // Hstde.setTImage(btm);
                    }

                    IMAGE_FLAG=CH_IMAGE_FLAG=false;
                }
            } else {
                if (requestcode == SELCT_FILE) {
                   Uri imge = data.getData();

                    try {
                      Bitmap  btm = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imge);
                        if (IMAGE_FLAG){
                            HStdIv.setImageBitmap(btm);
                            Hstde.setSImage(btm);
                        }else
                        if (CH_IMAGE_FLAG) {
                            Hchimage.setImageBitmap(btm);
                           // Hstde.setTImage(btm);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                }
            }
        }
    }
}
