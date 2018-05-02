package com.javier.starapiwars.models;

/**
 * Created by Javier on 09/04/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class People implements Serializable{

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("birthYear")
    @Expose
    private String birthYear;

    @SerializedName("eyeColor")
    @Expose
    private String eyeColor;

    @SerializedName("hairColor")
    @Expose
    private String hairColor;

    @SerializedName("height")
    @Expose
    private String height;

    @SerializedName("homeworld")
    @Expose
    private String homeworld;

    @SerializedName("imgDir")
    @Expose
    private String imgDir;

    @SerializedName("mass")
    @Expose
    private String mass;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("skinColor")
    @Expose
    private String skinColor;

    public String getGender() {
        return gender;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getHeight() {
        return height;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public String getMass() {
        return mass;
    }

    public String getName() {
        return name;
    }

    public String getSkinColor() {
        return skinColor;
    }


    public String getImgDir() {
        return imgDir;
    }
}