package com.javier.starapiwars;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.javier.starapiwars.models.FotosPeople;
import com.javier.starapiwars.models.People;
import com.javier.starapiwars.models.Planet;
import com.javier.starapiwars.retrofitUtils.RestServiceStarWars;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleFinalActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView tvNombre, tvAltura, tvPeso, tvColorPelo, tvColorOjos, tvColorPiel, tvPlanetaOrigen;
    private People people;
    private int posicion;

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

        people = (People) getIntent().getSerializableExtra("object");
        posicion = getIntent().getIntExtra("position", 0);

        tvNombre.setText(people.getName());
        tvAltura.setText(people.getHeight());
        tvPeso.setText(people.getMass());
        tvColorPelo.setText(people.getHairColor());
        tvColorOjos.setText(people.getEyeColor());
        tvColorPiel.setText(people.getSkinColor());
        tvPlanetaOrigen.setText(people.getHomeworld());
        FotosPeople fotosPeople = new FotosPeople();
        Drawable drawable = getResources().getDrawable(fotosPeople.getFoto(posicion));
        imageView.setImageDrawable(drawable);
    }
}
