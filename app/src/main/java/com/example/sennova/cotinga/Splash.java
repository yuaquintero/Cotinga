package com.example.sennova.cotinga;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;


/**
 * Clase encargada de ejecutar el Splash o animación inicial de la app
 *
 */

public class Splash extends AppCompatActivity {


    public static final int segundos=4; //Tiempo deseado para la animación
    public static final int milisegundos=segundos*1000;
    private ProgressBar progreso;
    public static final int delay=2;
    MediaPlayer media;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();


        media=MediaPlayer.create(this,R.raw.aves);
        media.start();

        progreso=(ProgressBar)findViewById(R.id.barra_progreso);
        empezaranimacion();
    }

    /**
     * Método que permite implementar la animación de entrada
     *
     */
    public void empezaranimacion(){
        new CountDownTimer(milisegundos,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                progreso.setProgress(establecer(millisUntilFinished));
                progreso.setMax(maximo());
            }
            @Override
            public void onFinish() {
                media.pause();
                Intent nuevo=new Intent(Splash.this,Home.class);
                startActivity(nuevo);
                finish();
            }
        }.start();
    }

    /**
     * Método que establece la duración temporal en segundos
     * @return Tiempo deseado en milisegundos
     *
     */

    public int establecer(long mili){
        return (int)(milisegundos-mili)/1000;
    }

    /**
     * Método que establece la duración maxima de la animación
     * @return Tiempo maximo deseado
     *
     */
    public int maximo(){
        return segundos-delay;
    }


    }

