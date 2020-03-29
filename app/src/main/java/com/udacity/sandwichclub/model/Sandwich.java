package com.udacity.sandwichclub.model;

import java.util.List;

public class Sandwich {

    private String mainName;
    private List<String> alsoKnownAs = null;
    private String placeOfOrigin;
    private String description;
    private String image;
    private List<String> ingredients = null;

    /**
     * No args constructor for use in serialization
     */
    public Sandwich() {
    }
    //Public construtor for Sandwich Object
    public Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }
    //Getter method for mainName of sandwich
    public String getMainName() {
        return mainName;
    }
    //setter method for mainName of sandwich
    public void setMainName(String mainName) {
        this.mainName = mainName;
    }
    //getter method for alsoKnownAS names
    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }
    //setter method for alsoKnownAs names os sandwich
    public void setAlsoKnownAs(List<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }
    //getter method for origin place of sandwich
    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }
    //Setter method for place origin of sandwich
    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }
    //getter method for description of sandwich
    public String getDescription() {
        return description;
    }
    //getter method for description of sandwich
    public void setDescription(String description) {
        this.description = description;
    }
    //getter method for image of sandwich
    public String getImage() {
        return image;
    }
    //setter method for image of sandwich
    public void setImage(String image) {
        this.image = image;
    }
    //getter method  for ingredients of sandwich
    public List<String> getIngredients() {
        return ingredients;
    }
    //setter method for ingredients of sandwich
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
