package com.javier.starapiwars.logicStarShips;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.javier.starapiwars.MainActivity;
import com.javier.starapiwars.R;

public class StarshipActivity extends AppCompatActivity {
    private TextView text;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship);
        text = findViewById(R.id.textView);
        text.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/starjout.ttf"));
        mp = MediaPlayer.create(this,R.raw.on);
    }
        public void contStarship(View view) {

            mp = MediaPlayer.create(this,R.raw.on);
            startActivity(new Intent(this,ContStarship.class));
        }

        @Override
        public void onBackPressed() {
            mp = MediaPlayer.create(this,R.raw.off);
            mp.start();
            Intent intent = new Intent(StarshipActivity.this, MainActivity.class);
            startActivity(intent);
        }
}
