package com.javier.starapiwars;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.javier.starapiwars.logicPeople.PeopleActivity;
import com.javier.starapiwars.logicPlanets.PlanetsActivity;
import com.javier.starapiwars.logicStarShips.StarshipActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this,R.raw.on);
        img = findViewById(R.id.imageView2);
    }
    public void acPeople(View view) {
        mp = MediaPlayer.create(this,R.raw.on);
        mp.start();
        startActivity(new Intent(this,PeopleActivity.class));
    }

    public void acPlanets(View view) {
        mp = MediaPlayer.create(this,R.raw.on);
        mp.start();
        startActivity(new Intent(this,PlanetsActivity.class));
    }

    public void acStarships(View view) {
        mp = MediaPlayer.create(this,R.raw.on);
        mp.start();
        startActivity(new Intent(this,StarshipActivity.class));
    }

    @Override
    public void onBackPressed() {}
    public void twitter(View view) {
        Uri uri = Uri.parse (getString(R.string.refTwitter));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void facebook(View view) {
        String facebookId = getString(R.string.refFbApp);
        String facebookWeb = getString(R.string.refFbWeb);

    try{
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookId )));
    }
    catch(Exception e)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookWeb )));
    }
    }
    public void official(View view) {
        Uri uri = Uri.parse (getString(R.string.refOfWeb));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void musica(View view) {
        mp = MediaPlayer.create(this,R.raw.breath);
        mp.start();
    }
}
