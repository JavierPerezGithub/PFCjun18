package com.javier.starapiwars.logicPlanets;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.javier.starapiwars.R;
import com.javier.starapiwars.models.Planet;

public class PlanetFinalActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView tvNombre, tvRotation, tvOrbital, tvDiameter, tvClimate, tvGravity, tvTerrain, tvSurface, tvPopulation;
    private Planet planet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_final);
        imageView = findViewById(R.id.ivPlanetFinal);
        tvNombre = findViewById(R.id.tvNamePlanetFinal);
        tvRotation = findViewById(R.id.tvRotationPlanetFinal);
        tvOrbital = findViewById(R.id.tvOrbitalPlanetFinal);
        tvDiameter = findViewById(R.id.tvDiameterPlanetFinal);
        tvClimate = findViewById(R.id.tvClimatePlanetFinal);
        tvGravity = findViewById(R.id.tvGravityPlanetFinal);
        tvTerrain = findViewById(R.id.tvTerrainPlanetFinal);
        tvSurface = findViewById(R.id.tvSurfacePlanetFinal);
        tvPopulation = findViewById(R.id.tvPopulationPlanetFinal);

        planet = (Planet) getIntent().getSerializableExtra("object");

        tvNombre.setText(planet.getName());
        tvRotation.setText(planet.getRotationPeriod());
        tvOrbital.setText(planet.getOrbitalPeriod());
        tvDiameter.setText(planet.getDiameter());
        tvClimate.setText(planet.getClimate());
        tvGravity.setText(planet.getGravity());
        tvTerrain.setText(planet.getTerrain());
        tvSurface.setText(planet.getSurfaceWater());
        tvPopulation.setText(planet.getPopulation());

        FirebaseStorage storage = FirebaseStorage.getInstance();
        String ref = "fotoPlanets/%1s";
        String res = String.format(ref,planet.getImgDir());
        StorageReference storageRef = storage.getReference().child(res);
        Glide.with(imageView.getContext())
                .using(new FirebaseImageLoader())
                .load(storageRef)
                .into(imageView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu_generic, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_exit) {
            crearDialogo().show();
        }
        return (true);
    }

    @SuppressLint("NewApi")
    public void Salida() {
        finishAffinity();
    }

    private Dialog crearDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(PlanetFinalActivity.this);
        builder.setCancelable(false);
        builder.setMessage("DO YOU WANT TO EXIT?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Salida();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder.create();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(PlanetFinalActivity.this, ContPlanet.class);
        startActivity(intent);
        finish();
    }
}
