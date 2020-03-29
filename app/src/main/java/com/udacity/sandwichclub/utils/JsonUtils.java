package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.DetailActivity;
import com.udacity.sandwichclub.MainActivity;
import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {


    public static Sandwich parseSandwichJson(String json) {
       //list and sandwich variable initialization
        List<String> alsoNameList;
        Sandwich sandwich=null;
        //parsing JSON response
        try {
            JSONObject baseName = new JSONObject(json);
            JSONObject name= baseName.getJSONObject("name");
            String mainName = name.getString("mainName");
            Log.i("DetailsActivity","MainName"+mainName);
            JSONArray nameJSONArray = name.getJSONArray("alsoKnownAs");
            alsoNameList = new ArrayList<String>();
            if (nameJSONArray.length()>0){
                for (int i=0;i<nameJSONArray.length();i++){
                    String subName=nameJSONArray.getString(i);
                    alsoNameList.add(subName);
                }

            }
            else {
                alsoNameList=null;
            }
            String origin =baseName.getString("placeOfOrigin");

            String description = baseName.getString("description");
            String image =baseName.getString("image");
            List<String> ingredientslist = new ArrayList<String>();
            JSONArray ingredientJSONArray = baseName.getJSONArray("ingredients");
            for (int j=0;j<ingredientJSONArray.length();j++)
            {
                String ingredient_name=ingredientJSONArray.getString(j);
                ingredientslist.add(ingredient_name);
            }

            //creating a sandwich object with the help of string which we got from JSON response
            sandwich= new Sandwich(mainName,alsoNameList,origin,description,image,ingredientslist);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
