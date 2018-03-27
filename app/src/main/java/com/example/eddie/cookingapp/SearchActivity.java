package com.example.eddie.cookingapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by eddie on 2/14/18.
 */




public class SearchActivity extends AppCompatActivity {
    private Context mContext;
    private Spinner mPrepSpinner;
    private Spinner mDietSpinner;
    private Spinner mServingSpinner;
    private ImageButton mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mContext = this;
        mPrepSpinner = findViewById(R.id.preptime_spinner);
        mDietSpinner = findViewById(R.id.diet_spinner);
        mServingSpinner = findViewById(R.id.serving_spinner);
        mBackButton = findViewById(R.id.backButton);
        final ArrayList<Recipe> recipeList = Recipe.getRecipesFromFile("recipes.json", this);
        ArrayList<String> pickOneTag = new ArrayList<String>();
        pickOneTag.add("None");
        for(int position = 0; position < recipeList.size(); position++){
            String pickOneCurrent = recipeList.get(position).label;
            if (!pickOneTag.contains(pickOneCurrent)){
                pickOneTag.add(pickOneCurrent);
            }

        }

        //set adapter for dietspinner
        ArrayAdapter<String> tagAdapt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, pickOneTag);
        mDietSpinner.setAdapter(tagAdapt);
        String[] serving = new String[]{"None", "Less than 4", "4-6", "7-9", "More than 10"};

        //set adapter for servingspinner
        ArrayAdapter<String> servingAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, serving);
        mServingSpinner.setAdapter(servingAdapter);
        String[] time = new String[]{"None", "30 min or less", "Less than 1 hr", "More than 1 hr"};

        //set adapter for prepspinner
        ArrayAdapter<String> timeAdapt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, time);
        mPrepSpinner.setAdapter(timeAdapt);


    }
    public void onClick(View view){
        Intent nextScreen = new Intent(getApplicationContext(), ResultsActivity.class);
        nextScreen.putExtra("label", mDietSpinner.getSelectedItem().toString());
        nextScreen.putExtra("serving", mServingSpinner.getSelectedItem().toString());
        nextScreen.putExtra("time", mPrepSpinner.getSelectedItem().toString());
        startActivity(nextScreen);

        mBackButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
