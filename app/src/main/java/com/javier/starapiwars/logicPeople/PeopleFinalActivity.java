package com.javier.starapiwars.logicPeople;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
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
import com.javier.starapiwars.models.People;

public class PeopleFinalActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView tvNombre, tvAltura, tvPeso, tvColorPelo, tvColorOjos, tvColorPiel, tvPlanetaOrigen, text,text1,text2,text3,text4,text5,text6,text7,text8,text9;
    private TextView tvYear,tvGender;
    private People people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_people_final);
        imageView = findViewById(R.id.ivPeopleFinal);
        tvNombre = findViewById(R.id.tvNombrePeopleFinal);
        tvNombre.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvAltura = findViewById(R.id.tvAlturaPeopleFinal);
        tvAltura.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvPeso = findViewById(R.id.tvPesoPeopleFinal);
        tvPeso.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvColorPelo = findViewById(R.id.tvColorPeloPeopleFinal);
        tvColorPelo.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvColorOjos = findViewById(R.id.tvColorOjosPeopleFinal);
        tvColorOjos.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvColorPiel = findViewById(R.id.tvColorPielPeopleFinal);
        tvColorPiel.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvPlanetaOrigen = findViewById(R.id.tvPlanetaPeopleFinal);
        tvPlanetaOrigen.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvYear = findViewById(R.id.tvYearPeopleFinal);
        tvYear.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvGender = findViewById(R.id.tvGenderPeopleFinal);
        tvGender.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));

        text = findViewById(R.id.textView2);
        text.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        text1 = findViewById(R.id.textView5);
        text1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        text2 = findViewById(R.id.textView6);
        text2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        text3 = findViewById(R.id.textView5);
        text3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        text4 = findViewById(R.id.textView7);
        text4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        text5 = findViewById(R.id.textView8);
        text5.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        text6 = findViewById(R.id.textView9);
        text6.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        text7 = findViewById(R.id.textView10);
        text7.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        text8 = findViewById(R.id.textView11);
        text8.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        text9 = findViewById(R.id.textView12);
        text9
                .setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));

        people = (People) getIntent().getSerializableExtra("object");

        tvNombre.setText(people.getName());
        tvAltura.setText(people.getHeight());
        tvPeso.setText(people.getMass());
        tvColorPelo.setText(people.getHairColor());
        tvColorOjos.setText(people.getEyeColor());
        tvColorPiel.setText(people.getSkinColor());
        tvPlanetaOrigen.setText(people.getHomeworld());
        tvGender.setText(people.getGender());
        tvYear.setText(people.getBirthYear());

        FirebaseStorage storage = FirebaseStorage.getInstance();
        String ref = "fotoPeople/%1s";
        String res = String.format(ref,people.getImgDir());
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
        AlertDialog.Builder builder = new AlertDialog.Builder(PeopleFinalActivity.this);
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
        Intent intent = new Intent(PeopleFinalActivity.this, ContPeople.class);
        startActivity(intent);
    }
}
