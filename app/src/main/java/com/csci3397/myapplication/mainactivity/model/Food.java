package com.csci3397.myapplication.mainactivity.model;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;
public class Food extends AppCompatActivity {

    public static ArrayList<Food> FoodArrayList = new ArrayList<>();
    public static String Food_EDIT_EXTRA =  "foodEdit";

    private int id;
    private String title;
    private String description;
    private Date deleted;

    public Food(int id, String title, String description, Date deleted)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deleted = deleted;
    }

    public Food(int id, String title, String description)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        deleted = null;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle1() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }
}
