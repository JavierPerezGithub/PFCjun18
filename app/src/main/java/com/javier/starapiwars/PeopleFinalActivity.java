package com.javier.starapiwars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.javier.starapiwars.models.People;
import com.javier.starapiwars.models.PeopleRespuesta;
import com.javier.starapiwars.models.Planet;
import com.javier.starapiwars.retrofitUtils.RestServiceStarWars;
import com.javier.starapiwars.retrofitUtils.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class PeopleFinalActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView tvNombre,tvAltura,tvPeso,tvColorPelo,tvColorOjos,tvColorPiel,tvPlanetaOrigen;
    private People people;
    private int posicion;
    private Planet planet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_final);
        imageView = findViewById(R.id.ivPeopleFinal);
        tvNombre = findViewById(R.id.tvNombrePeopleFinal);
        tvAltura = findViewById(R.id.tvAlturaPeopleFinal);
        tvPeso = findViewById(R.id.tvPesoPeopleFinal);
        tvColorPelo = findViewById(R.id.tvColorPeloPeopleFinal);
        tvColorOjos = findViewById(R.id.tvColorOjosPeopleFinal);
        tvColorPiel = findViewById(R.id.tvColorPielPeopleFinal);
        tvPlanetaOrigen = findViewById(R.id.tvPlanetaPeopleFinal);
        planet = new Planet();
        people = (People)getIntent().getSerializableExtra("object");
        posicion = getIntent().getIntExtra("position",0);

        tvNombre.setText(people.getName());
        tvAltura.setText(people.getHeight());
        tvPeso.setText(people.getMass());
        tvColorPelo.setText(people.getHairColor());
        tvColorOjos.setText(people.getEyeColor());
        tvColorPiel.setText(people.getSkinColor());
        tvPlanetaOrigen.setText(origen());
    }

    private String origen() {
        String respuesta = "";

        Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(people.getHomeworld())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        respuesta = cargaDatos(retrofit);



        return respuesta;
    }
    private String cargaDatos(Retrofit retrofit){

        final RestServiceStarWars service = retrofit.create(RestServiceStarWars.class);
        Call<Planet> peopleRespuestaCall = service.obtenerPlaneta();

        peopleRespuestaCall.enqueue(new Callback<Planet>() {
            @Override
            public void onResponse(Call<Planet> call, Response<Planet> response) {

                if(response.isSuccessful()){
                    Planet planet = response.body();

                }else {
                    Log.e("error",response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<Planet> call, Throwable t) {
                Log.e("error", t.toString());
            }
        });
        return planet.getName();
    }

}
