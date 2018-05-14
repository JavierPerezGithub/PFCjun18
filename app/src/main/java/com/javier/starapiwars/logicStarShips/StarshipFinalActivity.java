package com.javier.starapiwars.logicStarShips;

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
import com.javier.starapiwars.models.Starship;

public class StarshipFinalActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView tvNombre, tvModel, tvManufacturer, tvCost, tvLength, tvAthmosphere, tvCrew;
    private TextView tvPassengers, tvCargoCap, tvConsumables, tvHyperDrive, tvMglt, tvStClass;
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
        tvModel.setText(starship.getModel());
        tvManufacturer.setText(starship.getManufacturer());
        tvCost.setText(starship.getCostInCredits());
        tvLength.setText(starship.getLength());
        tvAthmosphere.setText(starship.getMaxAtmospheringSpeed());
        tvCrew.setText(starship.getCrew());
        tvPassengers.setText(starship.getPassengers());
        tvCargoCap.setText(starship.getCargoCapacity());
        tvConsumables.setText(starship.getConsumables());
        tvHyperDrive.setText(starship.getHyperdriveRating());
        tvMglt.setText(starship.getMglt());
        tvStClass.setText(starship.getStarshipClass());

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