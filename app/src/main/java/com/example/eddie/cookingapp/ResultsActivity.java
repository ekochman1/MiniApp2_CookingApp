package com.example.eddie.cookingapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;



/**
 * Created by Eddie on 3/12/18.
 */

public class ResultsActivity extends AppCompatActivity {
    private Context mContext;
    private TextView mTextView;
    private ListView mListView;
    private ImageButton imageButton;
    private ImageButton mBackButton2;

    public void onClick(View view) {

        mBackButton2.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultsActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }



            private ArrayList<Recipe> searchList(ArrayList<Recipe> list) {
        ArrayList<Recipe> searchList = new ArrayList<>();
        int maxTime;
        int minTime;
        int maxServ;
        int minServ;
        String tag = this.getIntent().getExtras().getString("label");

        //set range for preparation time


        String prepTime = this.getIntent().getExtras().getString("time");
        if (prepTime.equals("30 min or less")) {
            maxTime = 30;
            minTime = 0;
        } else if (prepTime.equals("Less than 1 hr")) {
            maxTime = 59;
            minTime = 0;
        } else if (prepTime.equals("More than 1 hr")) {
            maxTime = 480;
            minTime = 60;
        } else {
            maxTime = 600;
            minTime = 0;

        }

                //set range for servings (How many servings?)

        String servings = this.getIntent().getExtras().getString("serving");
        if (servings.equals("Less than 4")) {
            maxServ = 3;
            minServ = 1;
        } else if (servings.equals("4-6")) {
            maxServ = 6;
            minServ = 4;
        } else if (servings.equals("7-9")) {
            maxServ = 9;
            minServ = 7;
        } else if (servings.equals("None")) {
            maxServ = 75;
            minServ = 1;
        } else {
            maxServ = 100;
            minServ = 20;
        }

        ArrayList<Integer> time = timeChange(list);
        for (int i = 0; i < list.size(); i++) {
            if (!tag.equals("None")) {
                if ((list.get(i).label.equals(tag)) && (minServ <= list.get(i).servings) && (maxServ >= list.get(i).servings)
                        && (time.get(i) >= minTime) && (time.get(i) <= maxTime)) {
                    searchList.add(list.get(i));

                } else {
                    if ((maxServ >= list.get(i).servings) && (minServ <= list.get(i).servings) && (time.get(i) >= minTime) && (time.get(i) <= maxTime)) {
                        searchList.add(list.get(i));
                    }
                }
            }

        }
        return searchList;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_recipe);
        ArrayList<Recipe> recipeArrayList = Recipe.getRecipesFromFile("recipes.json", this);
        ArrayList<Recipe> searchList = searchList(recipeArrayList);
        mContext = this;
        RecipeAdapter adapter = new RecipeAdapter(this, searchList);
        mTextView = findViewById(R.id.clicked_text_view);
        mListView = findViewById(R.id.recipe_list_view);
        imageButton = findViewById(R.id.start_cooking_button);
       // mBackButton2 = findViewById(R.id.BackButton2);
        mTextView.setText(searchList.size() + " recipes!");
        mTextView.setTextSize(24);
        mTextView.setTextColor(0xff000000);
        mListView.setAdapter(adapter);

    }

    private ArrayList<Integer> timeChange(ArrayList<Recipe> list) {
        ArrayList<Integer> time = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int min = 0;
            String pTime = list.get(i).prepTime;
            String[] itemsHolder = pTime.split(" ");
            ArrayList<String> items = new ArrayList<>(Arrays.asList(itemsHolder));
            if (items.contains("hour") || items.contains("hours")) {
                int k = items.indexOf("hours");
                if (k != -1) {
                    min += 60 * (Integer.valueOf(items.get(k - 1)));
                } else {
                    min += 60;
                }
            }
            if (items.contains("minutes")) {
                int k = items.indexOf("minutes");
                min += Integer.valueOf(items.get(k - 1));
            } else {
                min += 60;
            }
            time.add(min);
        }
        return time;
    }

}