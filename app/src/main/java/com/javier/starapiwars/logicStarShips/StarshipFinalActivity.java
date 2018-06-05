package com.javier.starapiwars.logicStarShips;

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
import com.javier.starapiwars.models.Starship;

public class StarshipFinalActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView tvNombre, tvModel, tvManufacturer, tvCost, tvLength, tvAthmosphere, tvCrew;
    private TextView tvPassengers, tvCargoCap, tvConsumables, tvHyperDrive, tvMglt, tvStClass
            , text,text1,text2,text3,text4,text5,text6,text7,text8,text9,text10;
    private Starship starship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship_final);
        imageView = findViewById(R.id.ivStarshipFinal);
        tvNombre = findViewById(R.id.tvNameStFinal);
        tvModel = findViewById(R.id.tvModelStFinal);
        tvManufacturer = findViewById(R.id.tvManufacStFinal);
        tvCost = findViewById(R.id.tvCostStFinal);
        tvLength = findViewById(R.id.tvlengthStFinal);
        tvAthmosphere = findViewById(R.id.tvAthmosphereStFinal);
        tvCrew = findViewById(R.id.tvCrewStFinal);
        tvPassengers = findViewById(R.id.tvPassengStFinal);
        tvCargoCap = findViewById(R.id.tvCargoCapStFinal);
        tvConsumables = findViewById(R.id.tvConsumStFinal);
        tvHyperDrive = findViewById(R.id.tvHyperStFinal);
        tvMglt = findViewById(R.id.tvMgltStFinal);
        tvStClass = findViewById(R.id.tvClassStFinal);
        tvConsumables = findViewById(R.id.tvConsumStFinal);
        tvHyperDrive = findViewById(R.id.tvHyperStFinal);
        tvMglt = findViewById(R.id.tvMgltStFinal);
        tvStClass = findViewById(R.id.tvClassStFinal);

        starship = (Starship) getIntent().getSerializableExtra("object");

        tvNombre.setText(starship.getName());
        tvNombre.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvModel.setText(starship.getModel());
        tvModel.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvManufacturer.setText(starship.getManufacturer());
        tvManufacturer.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvCost.setText(starship.getCostInCredits());
        tvCost.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvLength.setText(starship.getLength());
        tvLength.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvAthmosphere.setText(starship.getMaxAtmospheringSpeed());
        tvAthmosphere.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvCrew.setText(starship.getCrew());
        tvCrew.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvPassengers.setText(starship.getPassengers());
        tvPassengers.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvCargoCap.setText(starship.getCargoCapacity());
        tvCargoCap.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvConsumables.setText(starship.getConsumables());
        tvConsumables.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvHyperDrive.setText(starship.getHyperdriveRating());
        tvHyperDrive.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvMglt.setText(starship.getMglt());
        tvMglt.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        tvStClass.setText(starship.getStarshipClass());
        tvStClass.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));


        text = findViewById(R.id.textView2);
        text.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        text8 = findViewById(R.id.textView3);
        text8.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        text9 = findViewById(R.id.textView4);
        text9.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
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
        text7 = findViewById(R.id.textView11);
        text7.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        text7 = findViewById(R.id.textView12);
        text7.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        text7 = findViewById(R.id.textView13);
        text7.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        text7 = findViewById(R.id.textView14);
        text7.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));

        FirebaseStorage storage = FirebaseStorage.getInstance();
        String ref = "fotoStarships/%1s";
        String res = String.format(ref, starship.getImgDir());
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
        AlertDialog.Builder builder = new AlertDialog.Builder(StarshipFinalActivity.this);
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
        Intent intent = new Intent(StarshipFinalActivity.this, ContStarship.class);
        startActivity(intent);
        finish();
    }
}