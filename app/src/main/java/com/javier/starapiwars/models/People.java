package com.javier.starapiwars.models;

/**
 * Created by Javier on 09/04/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class People {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("height")
    @Expose
    public String height;
    @SerializedName("mass")
    @Expose
    public String mass;
    @SerializedName("hair_color")
    @Expose
    public String hairColor;
    @SerializedName("skin_color")
    @Expose
    public String skinColor;
    @SerializedName("eye_color")
    @Expose
    public String eyeColor;
    @SerializedName("birth_year")
    @Expose
    public String birthYear;
    @SerializedName("gender")
    @Expose
    public String gender;
    @SerializedName("homeworld")
    @Expose
    public String homeworld;
    @SerializedName("films")
    @Expose
    public List<String> films = null;
    @SerializedName("species")
    @Expose
    public List<String> species = null;
    @SerializedName("vehicles")
    @Expose
    public List<String> vehicles = null;
    @SerializedName("starships")
    @Expose
    public List<String> starships = null;
    @SerializedName("created")
    @Expose
    public String created;
    @SerializedName("edited")
    @Expose
    public String edited;
    @SerializedName("url")
    @Expose
    public String url;

    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getMass() {
        return mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public List<String> getFilms() {
        return films;
    }

    public List<String> getSpecies() {
        return species;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public List<String> getStarships() {
        return starships;
    }

    public String getCreated() {
        return created;
    }

    public String getEdited() {
        return edited;
    }

    public String getUrl() {
        return url;
    }
}
