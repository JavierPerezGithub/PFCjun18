package com.javier.starapiwars.models;

import android.graphics.drawable.Drawable;

import com.javier.starapiwars.R;

/**
 * Created by Javier on 26/04/2018.
 */

public class FotosPeople {

    public int getFoto(int posicion){
        int icono = 0;

        switch (posicion){
            case 1: icono = R.drawable.luke;
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }

        return icono;
    }
}
