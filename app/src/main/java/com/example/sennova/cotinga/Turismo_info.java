package com.example.sennova.cotinga;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.math.RoundingMode;
import java.text.DecimalFormat;


public class Turismo_info extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private TextView Tvnombre;
    private TextView Tvdireccion;
    private TextView Tvtelefono;
    private TextView Tvemail;
    private TextView Tvdistancia;
    private TextView Tvruta;
    private double Tvlat;
    private double Tvlon;
    private EditText Tvfoto;
    private TextView  Tvvaloracion;
    private TextView Tvcomentario;
    private TextView Tvenlace;
    private ImageView ViewFoto;
    private long id;
    private Permisos permiso;
    private View miLayout;
    Turismo_constructor miLugar;
    final Context contexto = this;
    private Button b_califica;
    private TextView tv_nota;
    private ImageButton b_telefono;
    private ImageButton b_correo;
    //private static final String urlStorage="gs://turismo-a3b2c.appspot.com";
    private static final String urlStorage="gs://aves-87563.appspot.com";
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef;
    private static  String FotoStore;
    //******
    public SharedPreferences pref;
//******

    public Turismo_info() {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.turismo_info);
        Bundle extras = getIntent().getExtras();
        int id = extras.getInt("id", -1);
        miLugar=Turismo.Lugares.get(id);
        miLayout = findViewById(R.id.turismo_detalle);

        //****************************
        //fragmento de código para crear el archivo de preferencias
        pref = contexto.getSharedPreferences("MisPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editar = pref.edit();
        editar.commit();
        //fragmento de código para crear el archivo de preferencias
        //****************************

        FotoStore=miLugar.getFoto();
        storageRef= storage.getReferenceFromUrl(urlStorage).child(FotoStore);

        Tvnombre = (TextView) findViewById(R.id.nombre);
        Tvnombre.setText( miLugar.getNombre());

        Tvdireccion = (TextView) findViewById(R.id.dir);
        Tvdireccion.setText(miLugar.getDireccion());

        Tvcomentario = (TextView) findViewById(R.id.comentario);
        Tvcomentario.setText(miLugar.getComentario());

        Tvenlace = (TextView) findViewById(R.id.enlace_inf);
        Tvenlace.setText(miLugar.getEnlace());

        ViewFoto= (ImageView) findViewById(R.id.foto);

       final long ONE_MEGABYTE = 1024 * 1024;
        storageRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                ViewFoto.setImageBitmap(bitmap);
            }
        });

        Tvtelefono = (TextView) findViewById(R.id.tel);
        String tel=String.valueOf(miLugar.getTelefono());
        Tvtelefono.setText(String.valueOf(miLugar.getTelefono()));



        Tvemail = (TextView) findViewById(R.id.temail);
        Tvemail.setText(miLugar.getEmail());

        Tvdistancia = (TextView) findViewById(R.id.dis);
        Tvdistancia.setText(miLugar.getDistancia());

        Tvruta = (TextView) findViewById(R.id.ruta);
        Tvruta.setText(miLugar.getRuta());
        //tv_nota = (TextView)findViewById(R.id.tv_nota);

        permiso = new Permisos(miLayout,Turismo_info.this);



        b_telefono = (ImageButton) findViewById(R.id.b_llamar2);
        b_telefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tele=String.valueOf(miLugar.getTelefono());

                if(tele != null)
                    permiso.LanzarLlamada(String.valueOf(miLugar.getTelefono()));
                else {
                    String msg=getString(R.string.no_tele);
                    Toast.makeText(Turismo_info.this,msg,Toast.LENGTH_SHORT).show();
                }
            }

        });

        b_califica = (Button)findViewById(R.id.b_califica);
        b_califica.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                //Agregar la opción de preferencias para validar si tiene o no la calificación
                if(Buscar_Mail(miLugar.getEmail())){
                    String msg=getString(R.string.no_calificar);
                    Toast.makeText(Turismo_info.this,msg,Toast.LENGTH_SHORT).show();
                }
                else{
                    openCustomDialog(miLayout);
                }
            }
        });

        //invocar código para enviar mail
        b_correo = (ImageButton) findViewById(R.id.b_mail2);
        b_correo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=miLugar.getEmail();
                if(mail != null)
                    permiso.Lanzar_Email(miLugar.getEmail(),1);
                else {
                    String msg=getString(R.string.no_mail);
                    Toast.makeText(Turismo_info.this,msg,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
//        permissionCheck = ContextCompat.checkSelfPermission(miActividad, Manifest.permission.CALL_PHONE);
        if (requestCode == permiso.SOLICITAR_PERMISO_LLAMADAS) {
            // Si la solicitud es cancelada, grantResults estará vacío.
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Snackbar.make(miLayout, getString(R.string.permiso_si),
                        Snackbar.LENGTH_SHORT)
                        .show();
//                permissionCheck = ContextCompat.checkSelfPermission(miActividad, Manifest.permission.CALL_PHONE);
                // permiso concedido, ejecutar la acción.
                permiso.HacerLlamada();

            } else {

                Snackbar.make(miLayout, getString(R.string.permiso_no),
                        Snackbar.LENGTH_SHORT)
                        .show();
                // permiso negado, no se puede continuar
            }
        }
    }

    public void openCustomDialog(View view){
        // dialogo personalizado
        final Dialog dialog = new Dialog(contexto);
        //asignar un layout XML para el diálogo
        dialog.setContentView(R.layout.dialogo_calificar);
        // personalizar componentes del XML
        Button botCalificar = (Button) dialog.findViewById(R.id.b_aceptar);
        final RatingBar rbValoracion = (RatingBar) dialog.findViewById(R.id.rb_calificar);
        //Acción del botón, cerrar ventana al terminar
        final double contador = miLugar.getContador();
        final double valoracion = miLugar.getValoracion();

        botCalificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float stars = rbValoracion.getRating();
                double nuevaNota = ((contador*valoracion)+stars)/(contador+1);
            //Aumentar en 1 el valor de contador en guia
                Escribir_DB(nuevaNota);
                //****************************
            //agregar el correo a misPrefs para indicar que ya tiene calificación
                Guardar_Mail(miLugar.getEmail());
                //tv_nota.setText(String.valueOf(stars));
                dialog.dismiss();
            }
        });

        dialog.show();
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
                Intent Home = new Intent(Turismo_info.this, Home.class);
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
    //Función para validar la existencia de un correo en las preferencias
    public boolean Buscar_Mail(String buscarMail){
        boolean estado;
        estado = pref.getBoolean(buscarMail,false);
        return estado;
    }

    //Función para escribir un correo ya calificado en las preferencias
    public void Guardar_Mail(String buscarMail){
        SharedPreferences.Editor editar = pref.edit();
        editar.putBoolean(buscarMail, true);
        editar.commit();
    }

    //Función para guardar en la base de datos la calificación
    public void Escribir_DB(final double nota){
        //código para implementar escritura en la base de datos
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();
        String rutaHijo = "turismo/"+miLugar.getKeyName()+"/contador";
        DatabaseReference upvotesRef = ref.child(rutaHijo);
        upvotesRef.runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {
                Integer currentValue = mutableData.getValue(Integer.class);
                if (currentValue == null) {
                    mutableData.setValue(1);
                } else {
                    mutableData.setValue(currentValue + 1);
                }

                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {
                System.out.println("Transaction completed");
            }
        });
        //código para implementar escritura en la base de datos

        rutaHijo = "turismo/"+miLugar.getKeyName()+"/valoracion";
        upvotesRef = ref.child(rutaHijo);
        upvotesRef.runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {
                Double currentValue = mutableData.getValue(Double.class);
                mutableData.setValue(nota);

                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {
                System.out.println("Transaction completed");
            }
        });
        //código para implementar escritura en la base de datos

    }
}

