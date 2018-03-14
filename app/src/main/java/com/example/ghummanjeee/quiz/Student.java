package com.example.ghummanjeee.quiz;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by GhummanJeee on 3/5/2018.
 */

public class Student implements Serializable {

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    String FName;
    String LName;
   // Float  Ratting;

    public Bitmap getSImage() {
        return SImage;
    }

    public void setSImage(Bitmap SImage) {
        this.SImage = SImage;
    }
//
//    public Bitmap getTImage() {
//        return TImage;
//    }
//
//    public void setTImage(Bitmap TImage) {
//        this.TImage = TImage;
//    }

  Bitmap SImage;
//    Bitmap TImage;

    public String getTName() {
        return TName;
    }

    public void setTName(String TName) {
        this.TName = TName;
    }

    public String getTLName() {
        return TLName;
    }

    public void setTLName(String TLName) {
        this.TLName = TLName;
    }

    String TName;
    String TLName;
}
