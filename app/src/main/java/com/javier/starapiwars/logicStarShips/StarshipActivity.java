package com.javier.starapiwars.logicStarShips;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.javier.starapiwars.MainActivity;
import com.javier.starapiwars.R;

public class StarshipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship);
    }
        public void contStarship(View view) {
            startActivity(new Intent(this,ContStarship.class));
        }

        @Override
        public void onBackPressed() {
            Intent intent = new Intent(StarshipActivity.this, MainActivity.class);
            startActivity(intent);
        }
}
