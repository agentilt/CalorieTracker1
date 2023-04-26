package com.csci3397.myapplication.mainactivity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.csci3397.myapplication.R;
import com.csci3397.myapplication.mainactivity.model.foodItems;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private List<foodItems> foodList;

    public FoodAdapter(List<foodItems> food) {
        foodList = food;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    // ...

    public class ViewHolder extends RecyclerView.ViewHolder {

        public EditText foodName;
        public EditText calorie;

        public ViewHolder(View itemView) {
            super(itemView);

            foodName = itemView.findViewById(R.id.food_name);
            calorie = itemView.findViewById(R.id.calories);

            // Add OnFocusChangeListener to EditText fields
            foodName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        // Update foodList with new food name
                        foodList.get(getAdapterPosition()).setName(foodName.getText().toString());
                        // Notify adapter that data has changed
                        notifyDataSetChanged();
                    }
                }
            });

            calorie.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        // Update foodList with new calorie value
                        foodList.get(getAdapterPosition()).setCalories(Integer.parseInt(calorie.getText().toString()));
                        // Notify adapter that data has changed
                        notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
