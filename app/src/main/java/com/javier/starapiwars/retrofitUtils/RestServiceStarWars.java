package com.javier.starapiwars.retrofitUtils;

import com.javier.starapiwars.models.PeopleRespuesta;
import com.javier.starapiwars.models.Planet;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Javier on 09/04/2018.
 */

public interface RestServiceStarWars {
    public static final String BASE_URL = "https://swapi.co/api/";

    @GET("people")
    Call<PeopleRespuesta> obtenerListaPeople(@Query("page")int page);
    @GET("planet")
    Call<Planet> obtenerPlaneta();
    /*@GET("planets")
    Call<PlanetsRespuesta> obtenerListaPlanets(@Query("page")int page);
    @GET("starships")
    Call<StarShipsRespuesta> obtenerListaStarships(@Query("page")int page);*/

}
