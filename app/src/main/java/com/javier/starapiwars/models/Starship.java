package com.javier.starapiwars.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Starship implements Serializable {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("model")
    @Expose
    public String model;
    @SerializedName("manufacturer")
    @Expose
    public String manufacturer;
    @SerializedName("costInCredits")
    @Expose
    public String costInCredits;
    @SerializedName("length")
    @Expose
    public String length;
    @SerializedName("maxAtmospheringSpeed")
    @Expose
    public String maxAtmospheringSpeed;
    @SerializedName("crew")
    @Expose
    public String crew;
    @SerializedName("passengers")
    @Expose
    public String passengers;
    @SerializedName("cargoCapacity")
    @Expose
    public String cargoCapacity;
    @SerializedName("consumables")
    @Expose
    public String consumables;
    @SerializedName("hyperdriveRating")
    @Expose
    public String hyperdriveRating;
    @SerializedName("mglt")
    @Expose
    public String mglt;
    @SerializedName("starshipClass")
    @Expose
    public String starshipClass;
    @SerializedName("imgDir")
    @Expose
    public String imgDir;

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public String getLength() {
        return length;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public String getCrew() {
        return crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    public String getMglt() {
        return mglt;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public String getImgDir() {
        return imgDir;
    }
}
