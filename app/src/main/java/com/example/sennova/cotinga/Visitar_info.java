package com.example.sennova.cotinga;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Visitar_info extends AppCompatActivity {

    private TextView Tvnombre;
    private TextView Tvlink;
    private TextView Tvdescripcion;
    private TextView Tvtipo;
    private ImageView ViewFoto;
    Visitar_constructor miSitio;
    private View miLayout;
    private Button BLink;
    String LinkSitio;

    private static final String urlStorage="gs://aves-87563.appspot.com";
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef;
    private static  String FotoStore;
    public Visitar_info() {
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitar_info);

        Bundle extras = getIntent().getExtras();
        int id = extras.getInt("id", -1);
        miSitio=Visitar.Sitios.get(id);
        miLayout = findViewById(R.id.guia_detalle);

        FotoStore=miSitio.getImagen();
        storageRef= storage.getReferenceFromUrl(urlStorage).child(FotoStore);

        Tvnombre = (TextView) findViewById(R.id.tvVisitarNombre);
        Tvnombre.setText( miSitio.getNombre());

        Tvlink = (TextView) findViewById(R.id.tvVisitarLink);
        Tvlink.setText( miSitio.getLink());

        BLink =(Button) findViewById(R.id.bLink);
        //LinkSitio=miSitio.getLink().toString();

        Tvdescripcion = (TextView) findViewById(R.id.tvVisitarDescripcion);
        Tvdescripcion.setText( miSitio.getDescripcion());

        Tvtipo = (TextView) findViewById(R.id.tvVisitarTipo);
        Tvtipo.setText(miSitio.getTipositio());


        ViewFoto= (ImageView) findViewById(R.id.ivVisitarFoto);
        final long ONE_MEGABYTE = 1024 * 1024;
        storageRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                ViewFoto.setImageBitmap(bitmap);
            }
        });

        BLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWebLink2 = new Intent(Intent.ACTION_VIEW);
                myWebLink2.setData(Uri.parse(miSitio.getLink()));
                startActivity(myWebLink2);
            }
        });

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
                Intent Home = new Intent(Visitar_info.this, Home.class);
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
