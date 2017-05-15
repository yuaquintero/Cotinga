package com.example.sennova.cotinga;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ave_info extends AppCompatActivity {


    String Identificador;
    Integer id;
    SQLiteDatabase db;
    ImageButton canto;
    String codigoave;
    String nombreave;
    String inglesave;
    String cientificoave;
    String formaave;
    String color1ave;
    String color2ave ;
    String picoave ;
    String pataave;
    String linkave;
    String rutaave;
    String conservaave;
    String residenciaave;
    String vistasave;
    String codigoact1;
    CheckBox avistamiento;

    private Permisos permiso;
    private View miLayout;
    private boolean camaraOk;

    TextView nombre,nombreingles,nombrecientifico,info1,info2,info3,info4,info5,info6,info7,info8;
    ImageView pajaro;


    //Para la cámara
    private final String ruta_fotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/misAves/";
    private File file = new File(ruta_fotos);
    private ImageButton boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ave_info);
        Bundle extras = getIntent().getExtras();

        nombre=(TextView) findViewById(R.id.ave_nombre);
        nombreingles=(TextView) findViewById(R.id.ave_nombre_en);
        nombrecientifico=(TextView) findViewById(R.id.ave_nombre_cientifico);
        info1=(TextView) findViewById(R.id.ave_informacion1);
        info2=(TextView) findViewById(R.id.ave_informacion2);
        info3=(TextView) findViewById(R.id.ave_informacion3);
        info4=(TextView) findViewById(R.id.ave_informacion4);
        info5=(TextView) findViewById(R.id.ave_informacion5);
        info6=(TextView) findViewById(R.id.ave_informacion6);
        info7=(TextView) findViewById(R.id.ave_informacion7);
        info8=(TextView) findViewById(R.id.ave_informacion8);
        canto=(ImageButton) findViewById(R.id.ave_link);
        pajaro=(ImageView)findViewById(R.id.ave_foto);
        avistamiento=(CheckBox)findViewById(R.id.chequeo);
        miLayout = findViewById(R.id.activity_ave_info);
        permiso = new Permisos(miLayout,Ave_info.this);
        camaraOk = false;

        //Cámara
        boton = (ImageButton) findViewById(R.id.btnTomaFoto);
        file.mkdirs(); //Crea el directorio

        Identificador=extras.getString("id");
        id = Integer.parseInt(Identificador);

        Aves_bd Ave = new Aves_bd(this);
        db=Ave.getWritableDatabase();


        String[] campos = new String[]{"codigo","color1","color2","colorpata","pico","forma","espanol","ingles","cientifico","residencia","conserva","link","rutas","vistas"};
        String[] args = new String[]{Identificador};
        Cursor c = db.query("Aves", campos, "codigo=?", args, null, null, null);

        if(c.moveToFirst()) {

            do {
                codigoave=c.getString(0);
                color1ave=c.getString(1);
                color2ave=c.getString(2);
                pataave=c.getString(3);
                picoave=c.getString(4);
                formaave=c.getString(5);
                nombreave=c.getString(6);
                inglesave=c.getString(7);
                cientificoave=c.getString(8);
                residenciaave=c.getString(9);
                conservaave=c.getString(10);
                linkave=c.getString(11);
                rutaave=c.getString(12);
                vistasave=c.getString(13);

            } while (c.moveToNext());
        }

        int resourceID = getResources().getIdentifier("ave_"+id, "drawable", getPackageName());
        pajaro.setBackgroundResource(resourceID);

        //Toast.makeText(Ave_info.this, vistasave+" Ha sido avistada", Toast.LENGTH_SHORT).show();

        if (vistasave.equals("1")){
            avistamiento.setChecked(true);
        }

        avistamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (avistamiento.isChecked()) {
                    Toast.makeText(Ave_info.this, nombreave+" Ha sido avistada", Toast.LENGTH_SHORT).show();
                    String[] campos2 = new String[]{"codigo","color1","color2","colorpata","pico","forma","espanol","ingles","cientifico","residencia","conserva","link","rutas","vistas"};
                    String[] args2 = new String[]{Identificador};
                    Cursor c2 = db.query("Aves", campos2, "codigo=?", args2, null, null, null);
                    if(c2.moveToFirst()) {
                        do {
                            codigoave=c2.getString(0);
                        } while (c2.moveToNext());
                    }
                    ContentValues nuevoValor = new ContentValues();
                    nuevoValor.put("vistas","1");
                    db.update("Aves", nuevoValor, "codigo=" + codigoave, null);
                }
            }
        });

        switch(Integer.parseInt(rutaave)){
            case 0:
                info8.setText(R.string.rutainfo1);
                break;
            case 1:
                info8.setText("Ventanas");
                break;
            case 2:
                info8.setText("Verdunmesina");
                break;
            case 3:
                info8.setText("Verdunmesina & Ventanas");
                break;
            case 4:
                info8.setText("SaladaMorroamarillo");
                break;
            case 7:
                info8.setText("SaladaMorroamarillo, Verdunmesina & Ventanas ");
                break;
            case 8:
                info8.setText("Herrera");
                break;
            case 9:
                info8.setText("Herrera & Ventanas");
                break;
            case 15:
                info8.setText("Herrera, SaladaMorroamarillo, Verdunmesina & Ventanas");
                break;
            case 13:
                info8.setText("Herrera, SaladaMorroamarillo & Ventanas");
                break;
            default:
                info8.setText(R.string.rutainfo1);
                break;
        }

        switch(Integer.parseInt(residenciaave)){
            case 0:
                info6.setText(R.string.endemismoinfo1);
                break;
            case 1:
                info6.setText(R.string.endemismoinfo2);
                break;
            default:
                info6.setText(R.string.endemismoinfo2);
                break;
        }

        switch(Integer.parseInt(conservaave)){
            case 0:
                info7.setText(R.string.conservainfo1);
                break;
            case 1:
                info7.setText(R.string.conservainfo2);
                break;
            case 2:
                info7.setText(R.string.conservainfo3);
                break;
            case 3:
                info7.setText(R.string.conservainfo4);
                break;
            default:
                info7.setText(R.string.conservainfo5);
                break;
        }

        switch(Integer.parseInt(formaave)){
            case 0:
                info1.setText(R.string.formainfo1);
                break;
            case 1:
                info1.setText(R.string.formainfo2);
                break;
            case 2:
                info1.setText(R.string.formainfo3);
                break;
            case 3:
                info1.setText(R.string.formainfo4);
                break;
            case 4:
                info1.setText(R.string.formainfo5);
                break;
            case 5:
                info1.setText(R.string.formainfo6);
                break;
            case 6:
                info1.setText(R.string.formainfo7);
                break;
            case 7:
                info1.setText(R.string.formainfo8);
                break;
            case 8:
                info1.setText(R.string.formainfo9);
                break;
            case 9:
                info1.setText(R.string.formainfo10);
                break;
            default:
                info1.setText(R.string.formainfo1);
                break;
        }

        switch(Integer.parseInt(picoave)){
            case 0:
                info2.setText(R.string.picoinfo1);
                break;
            case 1:
                info2.setText(R.string.picoinfo2);
                break;
            case 2:
                info2.setText(R.string.picoinfo3);
                break;
            case 3:
                info2.setText(R.string.picoinfo4);
                break;
            case 4:
                info2.setText(R.string.picoinfo5);
                break;
            case 5:
                info2.setText(R.string.picoinfo6);
                break;
            case 6:
                info2.setText(R.string.picoinfo7);
                break;
            case 7:
                info2.setText(R.string.picoinfo8);
                break;
            case 8:
                info2.setText(R.string.picoinfo9);
                break;
            case 9:
                info2.setText(R.string.picoinfo10);
                break;
            default:
                info2.setText(R.string.picoinfo1);
                break;
        }

        switch(Integer.parseInt(color1ave)){
            case 0:
                info3.setText(R.string.colorinfo1);
                break;
            case 1:
                info3.setText(R.string.colorinfo2);
                break;
            case 2:
                info3.setText(R.string.colorinfo3);
                break;
            case 3:
                info3.setText(R.string.colorinfo4);
                break;
            case 4:
                info3.setText(R.string.colorinfo5);
                break;
            case 5:
                info3.setText(R.string.colorinfo6);
                break;
            case 6:
                info3.setText(R.string.colorinfo7);
                break;
            case 7:
                info3.setText(R.string.colorinfo8);
                break;
            case 8:
                info3.setText(R.string.colorinfo9);
                break;
            case 9:
                info3.setText(R.string.colorinfo10);
                break;
            case 10:
                info3.setText(R.string.colorinfo11);
                break;
            case 11:
                info3.setText(R.string.colorinfo12);
                break;
            case 12:
                info3.setText(R.string.colorinfo13);
                break;
            case 13:
                info3.setText(R.string.colorinfo14);
                break;
            case 14:
                info3.setText(R.string.colorinfo15);
                break;
            case 15:
                info3.setText(R.string.colorinfo16);
                break;
            case 16:
                info3.setText(R.string.colorinfo17);
                break;
            case 17:
                info3.setText(R.string.colorinfo18);
                break;
            case 18:
                info3.setText(R.string.colorinfo19);
                break;
            default:
                info3.setText(R.string.colorinfo1);
                break;
        }

        switch(Integer.parseInt(color2ave)){
            case 0:
                info4.setText(R.string.colorinfo1);
                break;
            case 1:
                info4.setText(R.string.colorinfo2);
                break;
            case 2:
                info4.setText(R.string.colorinfo3);
                break;
            case 3:
                info4.setText(R.string.colorinfo4);
                break;
            case 4:
                info4.setText(R.string.colorinfo5);
                break;
            case 5:
                info4.setText(R.string.colorinfo6);
                break;
            case 6:
                info4.setText(R.string.colorinfo7);
                break;
            case 7:
                info4.setText(R.string.colorinfo8);
                break;
            case 8:
                info4.setText(R.string.colorinfo9);
                break;
            case 9:
                info4.setText(R.string.colorinfo10);
                break;
            case 10:
                info4.setText(R.string.colorinfo11);
                break;
            case 11:
                info4.setText(R.string.colorinfo12);
                break;
            case 12:
                info4.setText(R.string.colorinfo13);
                break;
            case 13:
                info4.setText(R.string.colorinfo14);
                break;
            case 14:
                info4.setText(R.string.colorinfo15);
                break;
            case 15:
                info4.setText(R.string.colorinfo16);
                break;
            case 16:
                info4.setText(R.string.colorinfo17);
                break;
            case 17:
                info4.setText(R.string.colorinfo18);
                break;
            case 18:
                info4.setText(R.string.colorinfo19);
                break;
            default:
                info4.setText(R.string.colorinfo1);
                break;
        }

        switch(Integer.parseInt(pataave)){
            case 0:
                info5.setText(R.string.colorinfo1);
                break;
            case 1:
                info5.setText(R.string.colorinfo2);
                break;
            case 2:
                info5.setText(R.string.colorinfo3);
                break;
            case 3:
                info5.setText(R.string.colorinfo4);
                break;
            case 4:
                info5.setText(R.string.colorinfo5);
                break;
            case 5:
                info5.setText(R.string.colorinfo6);
                break;
            case 6:
                info5.setText(R.string.colorinfo7);
                break;
            case 7:
                info5.setText(R.string.colorinfo8);
                break;
            case 8:
                info5.setText(R.string.colorinfo9);
                break;
            case 9:
                info5.setText(R.string.colorinfo10);
                break;
            case 10:
                info5.setText(R.string.colorinfo11);
                break;
            case 11:
                info5.setText(R.string.colorinfo12);
                break;
            case 12:
                info5.setText(R.string.colorinfo13);
                break;
            case 13:
                info5.setText(R.string.colorinfo14);
                break;
            case 14:
                info5.setText(R.string.colorinfo15);
                break;
            case 15:
                info5.setText(R.string.colorinfo16);
                break;
            case 16:
                info5.setText(R.string.colorinfo17);
                break;
            case 17:
                info5.setText(R.string.colorinfo18);
                break;
            case 18:
                info5.setText(R.string.colorinfo19);
                break;
            default:
                info5.setText(R.string.colorinfo1);
                break;
        }

        nombre.setText(nombreave);
        nombreingles.setText(inglesave);
        nombrecientifico.setText(cientificoave);

        canto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWebLink = new Intent(Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse(linkave));
                startActivity(myWebLink);
            }
        });


        //Clic al botón capturar
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camaraOk = permiso.ValidarCamara();
                if(camaraOk){

                    String file = ruta_fotos + getCode() + ".jpg";
                    File mi_foto = new File( file );
                    try {
                        mi_foto.createNewFile();
                    } catch (IOException ex) {
                        Log.e("ERROR ", "Error:" + ex);
                    }
                    //
                    Uri uri = Uri.fromFile( mi_foto );
                    //Abre la camara para tomar la foto
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    //Guarda imagen
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    //Retorna a la actividad
                    startActivityForResult(cameraIntent, 0);
                } else {
                    //No hay permisos para cámara o storage
                }
            }
        });

    }

    @SuppressLint("SimpleDateFormat")
    private String getCode() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
        String date = dateFormat.format(new Date() );
        String photoCode = nombreave+" "+ date;
        return photoCode;
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
                Intent Home = new Intent(Ave_info.this, Home.class);
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



    @Override
    public void onBackPressed() {
        Intent goback = new Intent(Ave_info.this, Aves.class);
        startActivity(goback);
        //Aves.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }

}
