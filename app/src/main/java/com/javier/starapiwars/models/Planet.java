package com.javier.starapiwars.models;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Planet implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rotationPeriod")
    @Expose
    private String rotationPeriod;
    @SerializedName("orbitalPeriod")
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
    @SerializedName("surfaceWater")
    @Expose
    private String surfaceWater;
    @SerializedName("population")
    @Expose
    private String population;

    @SerializedName("imgDir")
    @Expose
    private String imgDir;

    public String getName() {
        return name;
    }

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public String getDiameter() {
        return diameter;
    }

    public String getClimate() {
        return climate;
    }

    public String getGravity() {
        return gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }

    public String getPopulation() {
        return population;
    }

    public String getImgDir() {
        return imgDir;
    }
}