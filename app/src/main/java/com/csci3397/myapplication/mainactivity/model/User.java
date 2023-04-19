package com.csci3397.myapplication.mainactivity.model;

import java.util.Calendar;
import java.util.Date;

public class User {
    private String name;
    private int age;
    private double weight; // in kilograms
    private double height; // in meters
    private String sex;
    private String goal;
    private int dailyCalorieGoal;
    private int caloriesConsumed;
    private Calendar lastUpdate;

    public User() {
        this.name = "Eren";
        this.age = 20;
        this.weight = 81;
        this.height = 177;
        this.sex = "M";
        this.goal = "Lose Weight";
        this.dailyCalorieGoal = 2020;
        this.caloriesConsumed = 0;
        this.lastUpdate = Calendar.getInstance();
    }

    public int getDailyCalorieGoal() {
        return dailyCalorieGoal;
    }

    public void setDailyCalorieGoal(int dailyCalorieGoal) {
        this.dailyCalorieGoal = dailyCalorieGoal;
    }
    public void addFood(String foodName, int calories) {
        caloriesConsumed += calories;
        updateLastUpdate();
    }

    private void updateLastUpdate() {
        Calendar now = Calendar.getInstance();
        if (!isSameDay(now, lastUpdate)) {
            caloriesConsumed = 0;
        }
        lastUpdate = now;
    }

    private boolean isSameDay(Calendar c1, Calendar c2) {
        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) &&
                c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR);
    }

    public int getCalorieGoal() {
        return dailyCalorieGoal;
    }


    public int getCaloriesConsumed() {
        return caloriesConsumed;
    }

    public void setCaloriesConsumed(int caloriesConsumed) {
        this.caloriesConsumed = caloriesConsumed;
    }



    public double calculateBMR() {
        double bmr = 0;
        if (sex.equals("M")) {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height * 100) - (5.677 * age);
        } else if (sex.equals("F")) {
            bmr = 447.593 + (9.247 * weight) + (3.098 * height * 100) - (4.330 * age);
        }
        return bmr;
    }

    public int calculateDailyCalorieNeeds() {
        double bmr = calculateBMR();
        int activityLevel = 1; // 1 = sedentary
        double dailyCalorieNeeds = bmr * activityLevel;
        return (int) Math.round(dailyCalorieNeeds);
    }

    public int calculateCaloriesLeftToConsume() {
        return dailyCalorieGoal - caloriesConsumed;
    }

    public double getWeightInPounds() {
        return weight * 2.20462;
    }

    public void setWeightInPounds(double weightInPounds) {
        weight = weightInPounds / 2.20462;
    }

    public double getHeightInFeet() {
        return height * 3.28084;
    }

    public void setHeightInFeet(double heightInFeet) {
        height = heightInFeet / 3.28084;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}
