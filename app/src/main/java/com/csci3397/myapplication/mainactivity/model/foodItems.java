package com.csci3397.myapplication.mainactivity.model;
import java.util.Date;
public class foodItems {
        private String name;
        private int calories;
        private Date date;

        public foodItems(String name, int calories) {
            this.name = name;
            this.calories = calories;
            this.date = new Date(); // Set date to current date
        }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public Date getDate() {
        return date;
    }


}
