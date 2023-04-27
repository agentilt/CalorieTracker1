package com.csci3397.myapplication.mainactivity.view;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

import com.csci3397.myapplication.R;
import com.csci3397.myapplication.mainactivity.model.Food;
import com.csci3397.myapplication.mainactivity.model.SQLiteManager;

import java.util.Date;

public class FoodDetailActivity extends AppCompatActivity
{
    private EditText titleEditText, descEditText;
    private Button deleteButton;
    private Food selectedFood;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        initWidgets();
        checkForEditNote();
    }

    private void initWidgets()
    {
        titleEditText = findViewById(R.id.titleEditText);
        descEditText = findViewById(R.id.CaloriesEditText);
       // deleteButton = findViewById(R.id.deleteNoteButton);
    }

    public void saveFood(View view)
    {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        String title = String.valueOf(titleEditText.getText());
        String desc = String.valueOf(descEditText.getText());

        if(selectedFood == null)
        {
            int id = Food.FoodArrayList.size();
            Food newNote = new Food(id, title, desc);
            Food.FoodArrayList.add(newNote);
            sqLiteManager.addFoodToDatabase(newNote);
        }
        else
        {
            selectedFood.setTitle(title);
            selectedFood.setDescription(desc);
            sqLiteManager.updateFoodInDB(selectedFood);
        }

        finish();
    }
    private void checkForEditNote()
    {
        Intent previousIntent = getIntent();

        int passedFoodID = previousIntent.getIntExtra(Food.Food_EDIT_EXTRA, -1);
        selectedFood = Food.getFoodForID(passedFoodID);

        if (selectedFood != null)
        {
            titleEditText.setText(selectedFood.getTitle());
            descEditText.setText(selectedFood.getDescription());
        }
        else
        {
            deleteButton.setVisibility(View.INVISIBLE);
        }
    }

    public void deleteFood(View view)
    {
        selectedFood.setDeleted(new Date());
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        sqLiteManager.updateFoodInDB(selectedFood);
        finish();
    }

   /* public void saveNote(View view)
    {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        String title = String.valueOf(titleEditText.getText());
        String desc = String.valueOf(descEditText.getText());

        if(selectedNote == null)
        {
            int id = Note.noteArrayList.size();
            Note newNote = new Note(id, title, desc);
            Note.noteArrayList.add(newNote);
            sqLiteManager.addNoteToDatabase(newNote);
        }
        else
        {
            selectedNote.setTitle(title);
            selectedNote.setDescription(desc);
            sqLiteManager.updateNoteInDB(selectedNote);
        }

        finish();
    }



    public void saveFood(View view) {
    }*/
}