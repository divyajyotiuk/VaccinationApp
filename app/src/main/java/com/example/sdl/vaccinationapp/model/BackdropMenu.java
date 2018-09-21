package com.example.sdl.vaccinationapp.model;

import com.example.sdl.vaccinationapp.R;

import java.util.ArrayList;
import java.util.List;

public class BackdropMenu {

    private String title;
    private int imageID;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getImageID() {
        return imageID;
    }

    public String getTitle() {
        return title;
    }

    public static List<BackdropMenu> getData()
    {
       List<BackdropMenu> menu = new ArrayList<>();

       int images[] = getImages();
       String titles[] = getTitles();

      for(int i=0;i<titles.length;i++)
      {
          BackdropMenu menuList = new BackdropMenu();
          menuList.setTitle(titles[i]);
          menuList.setImageID(images[i]);
          menu.add(menuList);
      }

       return menu;
    }

    private static int[] getImages()
    {
        int images[] = {R.drawable.baseline_account_circle_black_18dp,
                R.drawable.baseline_insert_chart_black_18dp,
                R.drawable.baseline_calendar_today_black_18dp,
                R.drawable.baseline_info_black_18dp,
                R.drawable.baseline_feedback_black_18dp,
                R.drawable.baseline_settings_black_18dp };
        return images;
    }

    private static String[] getTitles()
    {
        String titles[] = { "My Account", "Vaccine Chart", "Calendar", "Info", "Feedback", "Settings" };
        return titles;
    }
}
