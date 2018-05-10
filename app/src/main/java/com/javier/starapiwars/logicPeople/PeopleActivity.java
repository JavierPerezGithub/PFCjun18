package com.javier.starapiwars.logicPeople;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.javier.starapiwars.MainActivity;
import com.javier.starapiwars.R;

public class PeopleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
    }
    public void contPeople(View view) {
        startActivity(new Intent(this,ContPeople.class));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(PeopleActivity.this, MainActivity.class);
        startActivity(intent);
    }
}