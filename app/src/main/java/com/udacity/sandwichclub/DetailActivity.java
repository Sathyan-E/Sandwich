package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //binding imageView
        ImageView ingredientsIv = findViewById(R.id.image_iv);
        //getting intent
        Intent intent = getIntent();
        if (intent == null) {
            Toast.makeText(this, "intent is null", Toast.LENGTH_SHORT).show();
            closeOnError();
        }
        //getting postion value from intent
        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            Toast.makeText(this, "Position is equal to default value", Toast.LENGTH_SHORT).show();
            closeOnError();
            return;
        }
        //getting sandwich array from resources
        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            Toast.makeText(this, "Sandwich is null", Toast.LENGTH_SHORT).show();
            // Sandwich data unavailable
            closeOnError();
            return;
        }
        //populate the UI with the help of parsed JSON values of sandwich
        populateUI(sandwich);
        //setting images from the url got from sandwich object
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);
        //setting the title based on the sandwich's mainName
        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Sandwich sandwich) {
        //Binding all Textviews
        TextView origin = (TextView)findViewById(R.id.origin_tv);
        TextView knownAs = (TextView)findViewById(R.id.also_known_tv);
        TextView description = (TextView)findViewById(R.id.description_tv);
        TextView ingredients = (TextView) findViewById(R.id.ingredients_tv);
        //getting origin from sandwich object
        String originPlace = sandwich.getPlaceOfOrigin();
        if (originPlace.length()==0)
        {
            origin.setText(getResources().getString(R.string.no_details));
        }
        else {
            origin.setText(originPlace);
        }
        //knownAs list from sandwich object
        List<String> knownAsList = sandwich.getAlsoKnownAs();
        if (knownAsList==null)
        {
            knownAs.setText("No names");
        }
        else {
            for (int i=0;i<knownAsList.size();i++)
            {
                String knownName = knownAsList.get(i);
                knownAs.append(knownName+", ");
            }
        }
        description.setText(sandwich.getDescription());
        List<String> ingredientList =sandwich.getIngredients();
        if (ingredientList== null)
        {
            ingredients.setText("No Ingredients Available");
        }
        else {
            for (int i=0;i<ingredientList.size();i++)
            {
                String ingredient =ingredientList.get(i);
                ingredients.append(ingredient+", ");
            }
        }
    }
}
