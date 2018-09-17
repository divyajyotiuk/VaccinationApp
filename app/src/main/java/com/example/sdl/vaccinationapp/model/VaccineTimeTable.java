package com.example.sdl.vaccinationapp.model;

import android.support.annotation.NonNull;

import com.example.sdl.vaccinationapp.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Queue;

public class VaccineTimeTable {

    private String title;
    private int image;
    private String date;

    public static Date valueOf (String s)
    {
       Date date = new Date();
        return date;
    }
        public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public void setImage(int image)
    {
        this.image = image;
    }

    public int getImage()
    {
        return image;
    }
    public String getTitle()
    {
        return title;
    }

    public String getDate()
    {
        return date;
    }
    public static ArrayList<VaccineTimeTable> getdata(){

        ArrayList<VaccineTimeTable> datalist = new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            int images[] = getImages();
            VaccineTimeTable table = new VaccineTimeTable();
            table.setImage(images[i]);
            table.setTitle("Vaccine "+ i);
            datalist.add(table);
        }
        return datalist;
    }

    public static int[] getImages()
    {
        int[] images = {
                R.drawable.baseline_done_black_18,
                R.drawable.baseline_done_black_18,
                R.drawable.baseline_done_black_18,
                R.drawable.baseline_done_black_18,
                R.drawable.baseline_done_black_18,
                R.drawable.baseline_done_black_18,
                R.drawable.baseline_done_black_18,
                R.drawable.baseline_done_black_18,
                R.drawable.baseline_done_black_18,
                R.drawable.baseline_done_black_18
        } ;
        return images;
    }
}
