package com.javier.starapiwars;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    private ImageView emuerte,nave,nave2,navedarth,star,wars,app;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        emuerte = findViewById(R.id.emuerte);
        nave = findViewById(R.id.nave);
        nave2 = findViewById(R.id.nave2);
        navedarth = findViewById(R.id.navedarth);
        star = findViewById(R.id.star);
        wars = findViewById(R.id.wars);
        app = findViewById(R.id.app);
        mp = MediaPlayer.create(this,R.raw.empire);

        Animation decre = AnimationUtils.loadAnimation(this,R.anim.emuerte);
        Animation decre1 = AnimationUtils.loadAnimation(this,R.anim.nave);
        Animation decre2 = AnimationUtils.loadAnimation(this,R.anim.nave2);
        Animation decre3 = AnimationUtils.loadAnimation(this,R.anim.navedarth);
        Animation decre4 = AnimationUtils.loadAnimation(this,R.anim.star);
        Animation decre5 = AnimationUtils.loadAnimation(this,R.anim.wars);
        Animation decre6 = AnimationUtils.loadAnimation(this,R.anim.app);

        emuerte.setAnimation(decre);
        nave.setAnimation(decre1);
        nave2.setAnimation(decre2);
        navedarth.setAnimation(decre3);
        star.setAnimation(decre4);
        wars.setAnimation(decre5);
        app.setAnimation(decre6);
        mp.start();
        Thread tiempo = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(4000);


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
