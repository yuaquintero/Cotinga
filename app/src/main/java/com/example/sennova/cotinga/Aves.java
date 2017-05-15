package com.example.sennova.cotinga;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase lee la informacion de la base de datos SQlite, la cual se recibe por el recyclerview para mostrarse en pantalla.
 */

public class Aves extends AppCompatActivity {

    List<Ave_constructor> lista_aves;
    private RecyclerView rv;
    SQLiteDatabase db;
    String[] codigoave = new String[290];
    String[] nombreave = new String[290];
    String[] inglesave = new String[290];
    String[] cientificoave = new String[290];
    String[] formaave = new String[290];
    String[] color1ave = new String[290];
    String[] color2ave = new String[290];
    String[] picoave = new String[290];
    String[] pataave = new String[290];
    String[] residenciaave = new String[290];
    String[] conservaave = new String[290];
    String[] linkave = new String[290];
    String[] rutasave = new String[290];
    String[] vistasave = new String[290];
    String aux = "sin" ;
    CardView card;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aves);

        rv = (RecyclerView) findViewById(R.id.lista_aves);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        Aves_bd Ave = new Aves_bd(this);
        db=Ave.getWritableDatabase();
        prepareMovieData();
        initializeAdapter();
        card=(CardView)findViewById(R.id.aves_cardview);

    }

    /**
     * Método que inicializa el adaptador del recyclerview
     */
    private void initializeAdapter(){
        adaptador_aves adapter = new adaptador_aves(lista_aves);
        rv.setAdapter(adapter);
    }


    //Se busca en base de datos local la informacion rederente al id del ave seleccionada por el usuario
    private void prepareMovieData() {
        lista_aves = new ArrayList<>();
        String[] Arreglo = new String[290];
        String contador;
        Integer cuenta=0;

        for (int i = 0; i <290; i ++) {
            cuenta=1+i;
            contador= String.valueOf(cuenta);
            Arreglo[i] = contador;

            String[] campos = new String[]{"codigo","color1","color2","colorpata","pico","forma","espanol","ingles","cientifico","residencia","conserva","link","rutas","vistas"};
            String[] args = new String[]{Arreglo[i]};

            Cursor c = db.query("Aves", campos, "codigo=?", args, null, null, null);

            if(c.moveToFirst()){

                do{
                    codigoave[i]=c.getString(0);
                    color1ave[i]=c.getString(1);
                    color2ave[i]=c.getString(2);
                    pataave[i]=c.getString(3);
                    picoave[i]=c.getString(4);
                    formaave[i]=c.getString(5);
                    nombreave[i]=c.getString(6);
                    inglesave[i]=c.getString(7);
                    cientificoave[i]=c.getString(8);
                    residenciaave[i]=c.getString(9);
                    conservaave[i]=c.getString(10);
                    linkave[i]=c.getString(11);
                    rutasave[i]=c.getString(12);
                    vistasave[i]=c.getString(13);

                }while (c.moveToNext());
            }

            if(vistasave[i].equals("1")){
                aux="Avistada";
            }else {
                aux="";
            }


            int resourceID = getResources().getIdentifier("ave_"+cuenta, "drawable", getPackageName());
            lista_aves.add(new Ave_constructor(nombreave[i],cientificoave[i],inglesave[i],aux,resourceID));





        }

    }


    @Override
    public void onBackPressed() {
        Intent goback = new Intent(Aves.this, Home.class);
        ActivityCompat.finishAffinity(this);
        startActivity(goback);
        goback.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }


}
