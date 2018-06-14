package com.javier.starapiwars.logicPlanets;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.javier.starapiwars.MainActivity;
import com.javier.starapiwars.R;

public class PlanetsActivity extends AppCompatActivity {
    private TextView text;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);
        text = findViewById(R.id.textView);
        text.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        mp = MediaPlayer.create(this, R.raw.ewok);

    }

    public void contPlanet(View view) {
        mp.start();
        startActivity(new Intent(this, ContPlanet.class));
    }

    @Override
    public void onBackPressed() {
        mp = MediaPlayer.create(this, R.raw.off);
        mp.start();
        Intent intent = new Intent(PlanetsActivity.this, MainActivity.class);
        startActivity(intent);
    }
}