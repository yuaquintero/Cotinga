package com.example.sennova.cotinga;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Filtro extends AppCompatActivity {

    TextView colorprimario, colorsecundario,formapico, formaave, tamano;
    private RecyclerView rv;
    List<Ave_constructor> lista_aves;
    SQLiteDatabase db;
    String[] codigoave = new String[290];
    String[] nombreave = new String[290];
    String[] inglesave = new String[290];
    String[] cientificoave = new String[290];
    String[] formaaves = new String[290];
    String[] color1ave = new String[290];
    String[] color2ave = new String[290];
    String[] picoave = new String[290];
    String[] pataave = new String[290];
    String[] residenciaave = new String[290];
    String[] conservaave = new String[290];
    String[] linkave = new String[290];
    String[] rutasave = new String[290];
    String[] vistasave = new String[290];
    Integer aves=0;
    String aux = "sin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro);

        colorprimario = (TextView) findViewById(R.id.tvCriterio11);
        colorsecundario = (TextView) findViewById(R.id.tvCriterio22);
        formapico = (TextView) findViewById(R.id.tvCriterio44);
        formaave = (TextView) findViewById(R.id.tvCriterio55);
        tamano = (TextView) findViewById(R.id.tamano);
        Intent intent=getIntent();
        Bundle extras =intent.getExtras();

        //Evalúa los datos traídos de actividad anterior
        if (extras != null) {//ver si contiene datos
            String colorPrimarioR=(String)extras.get("colorPrimario");
            String colorSecundarioR=(String)extras.get("colorSecundario");
            String formaPicoR= (String) extras.get("formaPico");
            String formaAveR= (String) extras.get("formaAve");

            colorprimario.setText(colorPrimarioR);
            colorsecundario.setText(colorSecundarioR);
            formapico.setText(formaPicoR);
            formaave.setText(formaAveR);
        }else{
            colorprimario.setText("0");
            colorsecundario.setText("0");
            formapico.setText("0");
            formaave.setText("0");
        }

        //Si algún dato de los RadioButton vienen vacíos, asigna cero
        if(colorprimario.getText()==""){
            colorprimario.setText("0");
        }
        if(colorsecundario.getText()==""){
            colorsecundario.setText("0");
        }
        if(formapico.getText()==""){
            formapico.setText("0");
        }
        if(formaave.getText()==""){
            formaave.setText("0");
        }


        rv = (RecyclerView) findViewById(R.id.lista_aves_filtro);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        Aves_bd Ave = new Aves_bd(this);
        db=Ave.getWritableDatabase();
        prepareMovieData();
        initializeAdapter();

        tamano.setText(aves.toString());


    }

    private void initializeAdapter(){
        adaptador_aves adapter = new adaptador_aves(lista_aves);
        rv.setAdapter(adapter);
    }


    private void prepareMovieData() {

        lista_aves = new ArrayList<>();
        String[] Arreglo = new String[290];
        String contador;
        Integer cuenta = 0;


        for (int i = 0; i < 290; i++) {
            cuenta = 1 + i;
            contador = String.valueOf(cuenta);
            Arreglo[i] = contador;

            String[] campos = new String[]{"codigo", "color1", "color2", "colorpata", "pico", "forma", "espanol", "ingles", "cientifico", "residencia", "conserva", "link", "rutas","vistas"};
            String[] args = new String[]{Arreglo[i]};

            Cursor c = db.query("Aves", campos, "codigo=?", args, null, null, null);

            if (c.moveToFirst()) {

                do {
                    codigoave[i] = c.getString(0);
                    color1ave[i] = c.getString(1);
                    color2ave[i] = c.getString(2);
                    pataave[i] = c.getString(3);
                    picoave[i] = c.getString(4);
                    formaaves[i] = c.getString(5);
                    nombreave[i] = c.getString(6);
                    inglesave[i] = c.getString(7);
                    cientificoave[i] = c.getString(8);
                    residenciaave[i] = c.getString(9);
                    conservaave[i] = c.getString(10);
                    linkave[i] = c.getString(11);
                    rutasave[i] = c.getString(12);
                    vistasave[i]=c.getString(13);

                } while (c.moveToNext());
            }

            if(vistasave[i].equals("1")){
                aux="Avistada";
            }else{
                aux="";
            }

            if (colorprimario.getText().equals("0") && colorsecundario.getText().equals("0") && formaave.getText().equals("0") && formapico.getText().equals("0")) {
                int resourceID = getResources().getIdentifier("ave_" + cuenta, "drawable", getPackageName());
                lista_aves.add(new Ave_constructor(nombreave[i], cientificoave[i], inglesave[i], aux, resourceID));
                aves++;
            } else if (colorprimario.getText().equals("0")  && colorsecundario.getText().equals("0") && formaave.getText().equals("0") && formapico.getText().equals(picoave[i])) {
                int resourceID = getResources().getIdentifier("ave_" + cuenta, "drawable", getPackageName());
                lista_aves.add(new Ave_constructor(nombreave[i], cientificoave[i], inglesave[i], aux, resourceID));
                aves++;
            } else if (colorprimario.getText().equals("0") && colorsecundario.getText().equals("0") && formaave.getText().equals(formaaves[i]) && formapico.getText().equals("0")) {
                int resourceID = getResources().getIdentifier("ave_" + cuenta, "drawable", getPackageName());
                lista_aves.add(new Ave_constructor(nombreave[i], cientificoave[i], inglesave[i], aux, resourceID));
                aves++;
            } else if (colorprimario.getText().equals("0") && colorsecundario.getText().equals("0") && formaave.getText().equals(formaaves[i]) && formapico.getText().equals(picoave[i])) {
                int resourceID = getResources().getIdentifier("ave_" + cuenta, "drawable", getPackageName());
                lista_aves.add(new Ave_constructor(nombreave[i], cientificoave[i], inglesave[i], aux, resourceID));
                aves++;
            } else if (colorprimario.getText().equals("0") && colorsecundario.getText().equals(color2ave[i]) && formaave.getText().equals("0") && formapico.getText().equals("0")) {
                int resourceID = getResources().getIdentifier("ave_" + cuenta, "drawable", getPackageName());
                lista_aves.add(new Ave_constructor(nombreave[i], cientificoave[i], inglesave[i], aux, resourceID));
                aves++;
            } else if (colorprimario.getText().equals("0") && colorsecundario.getText().equals(color2ave[i]) && formaave.getText().equals("0") && formapico.getText().equals(picoave[i])) {
                int resourceID = getResources().getIdentifier("ave_" + cuenta, "drawable", getPackageName());
                lista_aves.add(new Ave_constructor(nombreave[i], cientificoave[i], inglesave[i], aux, resourceID));
                aves++;
            } else if (colorprimario.getText().equals("0") && colorsecundario.getText().equals(color2ave[i]) && formaave.getText().equals(formaaves[i]) && formapico.getText().equals("0")) {
                int resourceID = getResources().getIdentifier("ave_" + cuenta, "drawable", getPackageName());
                lista_aves.add(new Ave_constructor(nombreave[i], cientificoave[i], inglesave[i], aux, resourceID));
                aves++;
            } else if (colorprimario.getText().equals("0") && colorsecundario.getText().equals(color2ave[i]) && formaave.getText().equals(formaaves[i]) && formapico.getText().equals(picoave[i])) {
                int resourceID = getResources().getIdentifier("ave_" + cuenta, "drawable", getPackageName());
                lista_aves.add(new Ave_constructor(nombreave[i], cientificoave[i], inglesave[i], aux, resourceID));
                aves++;
            } else if (colorprimario.getText().equals(color1ave[i]) && colorsecundario.getText().equals("0") &&  formaave.getText().equals("0") && formapico.getText().equals("0")) {
                int resourceID = getResources().getIdentifier("ave_" + cuenta, "drawable", getPackageName());
                lista_aves.add(new Ave_constructor(nombreave[i], cientificoave[i], inglesave[i], aux, resourceID));
                aves++;
            } else if (colorprimario.getText().equals(color1ave[i]) && colorsecundario.getText().equals("0") && formaave.getText().equals("0") && formapico.getText().equals(picoave[i])) {
                int resourceID = getResources().getIdentifier("ave_" + cuenta, "drawable", getPackageName());
                lista_aves.add(new Ave_constructor(nombreave[i], cientificoave[i], inglesave[i], aux, resourceID));
                aves++;
            } else if (colorprimario.getText().equals(color1ave[i]) && colorsecundario.getText().equals("0") && formaave.getText().equals(formaaves[i]) && formapico.getText().equals("0")) {
                int resourceID = getResources().getIdentifier("ave_" + cuenta, "drawable", getPackageName());
                lista_aves.add(new Ave_constructor(nombreave[i], cientificoave[i], inglesave[i], aux, resourceID));
                aves++;
            } else if (colorprimario.getText().equals(color1ave[i]) && colorsecundario.getText().equals("0") && formaave.getText().equals(formaaves[i]) && formapico.getText().equals(picoave[i])) {
                int resourceID = getResources().getIdentifier("ave_" + cuenta, "drawable", getPackageName());
                lista_aves.add(new Ave_constructor(nombreave[i], cientificoave[i], inglesave[i], aux, resourceID));
                aves++;
            } else if (colorprimario.getText().equals(color1ave[i]) && colorsecundario.getText().equals(color2ave[i]) &&  formaave.getText().equals("0") && formapico.getText().equals("0")) {
                int resourceID = getResources().getIdentifier("ave_" + cuenta, "drawable", getPackageName());
                lista_aves.add(new Ave_constructor(nombreave[i], cientificoave[i], inglesave[i], aux, resourceID));
                aves++;
            } else if (colorprimario.getText().equals(color1ave[i]) && colorsecundario.getText().equals(color2ave[i]) &&  formaave.getText().equals("0") && formapico.getText().equals(picoave[i])) {
                int resourceID = getResources().getIdentifier("ave_" + cuenta, "drawable", getPackageName());
                lista_aves.add(new Ave_constructor(nombreave[i], cientificoave[i], inglesave[i], aux, resourceID));
                aves++;
            } else if (colorprimario.getText().equals(color1ave[i]) && colorsecundario.getText().equals(color2ave[i]) &&  formaave.getText().equals(formaaves[i]) && formapico.getText().equals("0")) {
                int resourceID = getResources().getIdentifier("ave_" + cuenta, "drawable", getPackageName());
                lista_aves.add(new Ave_constructor(nombreave[i], cientificoave[i], inglesave[i], aux, resourceID));
                aves++;
            } else if (colorprimario.getText().equals(color1ave[i]) && colorsecundario.getText().equals(color2ave[i]) &&  formaave.getText().equals(formaaves[i]) && formapico.getText().equals(picoave[i])) {
                int resourceID = getResources().getIdentifier("ave_" + cuenta, "drawable", getPackageName());
                lista_aves.add(new Ave_constructor(nombreave[i], cientificoave[i], inglesave[i], aux, resourceID));
                aves++;
            }
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch ( item.getItemId() )
        {
            case R.id.boton_home:{
                Intent Home = new Intent(Filtro.this, Home.class);
                ActivityCompat.finishAffinity(this);
                startActivity(Home);
                Home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();

            }
            break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }



}
