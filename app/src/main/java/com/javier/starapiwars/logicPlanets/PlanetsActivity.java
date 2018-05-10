package com.javier.starapiwars.logicPlanets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.javier.starapiwars.MainActivity;
import com.javier.starapiwars.R;

public class PlanetsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);
    }
    public void contPlanet(View view) {
        startActivity(new Intent(this,ContPlanet.class));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(PlanetsActivity.this, MainActivity.class);
        startActivity(intent);
    }
}