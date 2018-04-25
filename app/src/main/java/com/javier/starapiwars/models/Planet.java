package com.javier.starapiwars.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Planet {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rotation_period")
    @Expose
    private String rotationPeriod;
    @SerializedName("orbital_period")
    @Expose
    private String orbitalPeriod;
    @SerializedName("diameter")
    @Expose
    private String diameter;
    @SerializedName("climate")
    @Expose
    private String climate;
    @SerializedName("gravity")
    @Expose
    private String gravity;
    @SerializedName("terrain")
    @Expose
    private String terrain;
    @SerializedName("surface_water")
    @Expose
    private String surfaceWater;
    @SerializedName("population")
    @Expose
    private String population;
    @SerializedName("residents")
    @Expose
    private List<String> residents = null;
    @SerializedName("films")
    @Expose
    private List<String> films = null;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("edited")
    @Expose
    private String edited;
    @SerializedName("url")
    @Expose
    private String url;

    public String getName() {
        return name;
    }
}