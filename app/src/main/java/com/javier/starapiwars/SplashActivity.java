package com.javier.starapiwars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    private ImageView emuerte,nave,nave2,navedarth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        emuerte = findViewById(R.id.emuerte);
        nave = findViewById(R.id.nave);
        nave2 = findViewById(R.id.nave2);
        navedarth = findViewById(R.id.navedarth);


        Animation decre = AnimationUtils.loadAnimation(this,R.anim.emuerte);
        Animation decre1 = AnimationUtils.loadAnimation(this,R.anim.nave);
        Animation decre2 = AnimationUtils.loadAnimation(this,R.anim.nave2);
        Animation decre3 = AnimationUtils.loadAnimation(this,R.anim.navedarth);

        emuerte.setAnimation(decre);
        nave.setAnimation(decre1);
        nave2.setAnimation(decre2);
        navedarth.setAnimation(decre3);

        Thread tiempo = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(5000);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        tiempo.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
