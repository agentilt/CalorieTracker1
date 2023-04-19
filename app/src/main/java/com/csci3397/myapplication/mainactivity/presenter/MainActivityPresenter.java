package com.csci3397.myapplication.mainactivity.presenter;

import com.csci3397.myapplication.mainactivity.view.MainActivity;

public class MainActivityPresenter {
    private MainActivity mView;

    public MainActivityPresenter(MainActivity view) {
        mView = view;
    }

    public void onInputCaloriesButtonClick() {
        //mView.showInputCaloriesScreen();
    }
}
