package com.javier.starapiwars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void acPeople(View view) {
        startActivity(new Intent(this,PeopleActivity.class));
    }

    /*public void acStarship(View view) {
        startActivity(new Intent(this,PlanetsActivity.class));
    }

    public void acPlanets(View view) {
        startActivity(new Intent(this,StarshipActivity.class));
    }

    public void acBusqueda(View view) {
        startActivity(new Intent(this,StarshipActivity.class));
    }*/
}
