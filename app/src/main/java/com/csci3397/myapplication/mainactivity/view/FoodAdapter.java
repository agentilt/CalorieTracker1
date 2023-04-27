package com.csci3397.myapplication.mainactivity.view;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import com.csci3397.myapplication.R;
import com.csci3397.myapplication.mainactivity.model.Food;

public class FoodAdapter extends ArrayAdapter<Food> {
    public FoodAdapter(Context context, List<Food> foods)
    {
        super(context, 0, foods);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Food food = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.food_cell, parent, false);

        TextView name = convertView.findViewById(R.id.cellName);
        TextView cals = convertView.findViewById(R.id.cellCal);

        name.setText(food.getTitle());
        cals.setText(food.getDescription());

        return convertView;
    }
}

