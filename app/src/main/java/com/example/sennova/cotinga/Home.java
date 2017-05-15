package com.example.sennova.cotinga;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

/**
 *  Clase encargada de ejecutar el Home o menú principal de la app utilizando la accion de 6 Imagebutton y un menu auxiliar
 *
 */

public class Home extends AppCompatActivity {

    ImageButton avistamiento, aves, guias, rutas, turismo,recomienda;
    Locale locale;
    MenuItem itemuno, itemdos, itemtres;
    private static ConnectivityManager manager;
    private final Context mContext=this;
    public static final int segundos=1; //Tiempo deseado para cargar bd
    public static final int milisegundos=segundos*1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));

        itemuno = (MenuItem) findViewById(R.id.menu1);
        itemdos = (MenuItem) findViewById(R.id.menu2);
        itemtres = (MenuItem) findViewById(R.id.menu3);
        avistamiento = (ImageButton) findViewById(R.id.boton_avistamiento);
        aves = (ImageButton) findViewById(R.id.boton_aves);
        guias = (ImageButton) findViewById(R.id.boton_guias);
        rutas = (ImageButton) findViewById(R.id.boton_rutas);
        turismo = (ImageButton) findViewById(R.id.boton_turismo);
        recomienda = (ImageButton) findViewById(R.id.boton_Recomendaciones);


        avistamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent avistar = new Intent(Home.this, Avistamiento.class);
                startActivity(avistar);
            }
        });

        aves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aves = new Intent(Home.this, Aves.class);
                startActivity(aves);
            }
        });

        recomienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent indicacion = new Intent(Home.this, Recomendaciones.class);
                startActivity(indicacion);
            }
        });

        turismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                String msgload=getString(R.string.carga2);
                Toast.makeText(Home.this,msgload,Toast.LENGTH_LONG).show();
                new CountDownTimer(milisegundos,1000) {
                    public void onFinish() {
                        // When timer is finished
                        // Execute your code here
                        if(isConnectedWifi(mContext)|| isConnectedMobile(mContext) )
                        {
                            if(isOnlineNet())
                                lanzarTurismo(view);
                            else {
                                String msg=getString(R.string.no_conexion);
                                Toast.makeText(Home.this,msg,Toast.LENGTH_LONG).show();
                            }

                        }
                        else {
                            String msg=getString(R.string.no_conexion);
                            Toast.makeText(Home.this,msg,Toast.LENGTH_SHORT).show();
                        }

                    }

                    public void onTick(long millisUntilFinished) {
                        // millisUntilFinished    The amount of time until finished.
                    }
                }.start();

            }
        });

        guias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                String msgload=getString(R.string.carga1);
                Toast.makeText(Home.this,msgload,Toast.LENGTH_LONG).show();
                new CountDownTimer(milisegundos,1000) {
                    public void onFinish() {
                        // When timer is finished
                        // Execute your code here
                        if(isConnectedWifi(mContext)|| isConnectedMobile(mContext) )
                        {
                            if(isOnlineNet())
                                lanzarGuia(view);
                            else {
                                String msg=getString(R.string.no_conexion);
                                Toast.makeText(Home.this,msg,Toast.LENGTH_LONG).show();
                            }

                        }
                        else {
                            String msg=getString(R.string.no_conexion);
                            Toast.makeText(Home.this,msg,Toast.LENGTH_SHORT).show();
                        }

                    }

                    public void onTick(long millisUntilFinished) {
                        // millisUntilFinished    The amount of time until finished.
                    }
                }.start();


            }
        });
    }

    /**
     * Metodo para incluir el menu de opciones en la barra de actividades del Home
     * @return Verdadero si el recurso XML del menú existe en el proyecto
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Metodo que permite seleccionar cada una de las actividades contenidas en el menu auxiliar
     * @return La actividad seleccionada por el usuario
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu2) {
            Intent turistica = new Intent(Home.this, Acerca_de.class);
            startActivity(turistica);
        }

        if(id==R.id.menu3) {

            String msgload=getString(R.string.carga3);
            Toast.makeText(Home.this,msgload,Toast.LENGTH_LONG).show();

            if (isConnectedWifi(mContext) || isConnectedMobile(mContext)) {
                if (isOnlineNet()) {
                    Intent interes2 = new Intent(Home.this, Visitar.class);
                    startActivity(interes2);
                } else {
                    String msg = getString(R.string.no_conexion);
                    Toast.makeText(Home.this, msg, Toast.LENGTH_SHORT).show();
                }
            } else {
                String msg = getString(R.string.no_conexion);
                Toast.makeText(Home.this, msg, Toast.LENGTH_SHORT).show();
            }

            return super.onOptionsItemSelected(item);
        }

        if (id == R.id.submenu1) {

            Locale locale = new Locale("en");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getApplication().getResources().getDisplayMetrics());
            getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }

        if (id == R.id.submenu2) {

            Locale locale = new Locale("es");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getApplication().getResources().getDisplayMetrics());
            getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * Comprueba si exite conexion a internet a traves de cualquier interfaz de red
     * mediante la realizacion de un ping a la pagina www.google.es
     * @return Estado de la conexion a internet
     */
    public Boolean isOnlineNet() {

        try {
            Process p = Runtime.getRuntime().exec("ping -c 1 www.google.es");
            int val           = p.waitFor();
            boolean reachable = (val == 0);
            return reachable;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Compueba si existe conexion a traves de la red WiFi
     * @param context Contexto
     * @return Estado de la conexion
     */
    public static boolean isConnectedWifi(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
    }

    /**
     * Compueba si existe conexion a traves de la red de datos movil.
     * @param context
     * @return Estado de la conexion.
     */
    public static boolean isConnectedMobile(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;
    }

    public void lanzarTurismo(View view){
        Intent i = new Intent(this, Turismo.class);
        startActivity(i);
    }

    public void lanzarGuia(View view){
        Intent j = new Intent(this, Guias.class);
        startActivity(j);
    }







    /*@Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }


    @Override
    public void onDestroy() {
        super.onBackPressed();
        super.onDestroy();

    }*/




}







