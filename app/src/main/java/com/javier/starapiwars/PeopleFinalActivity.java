package com.javier.starapiwars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.javier.starapiwars.models.People;

public class PeopleFinalActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView tvNombre, tvAltura, tvPeso, tvColorPelo, tvColorOjos, tvColorPiel, tvPlanetaOrigen;
    private People people;

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

        tvNombre.setText(people.getName());
        tvAltura.setText(people.getHeight());
        tvPeso.setText(people.getMass());
        tvColorPelo.setText(people.getHairColor());
        tvColorOjos.setText(people.getEyeColor());
        tvColorPiel.setText(people.getSkinColor());
        tvPlanetaOrigen.setText(people.getHomeworld());

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        Glide.with(imageView.getContext())
                .load(people.getImgDir())
                .into(imageView);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(PeopleFinalActivity.this, ContPeople.class);
        startActivity(intent);
        finish();
    }
}
