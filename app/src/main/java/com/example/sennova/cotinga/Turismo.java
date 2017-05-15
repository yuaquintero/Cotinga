package com.example.sennova.cotinga;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Turismo extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    RecyclerView rv;
    public static  List<Turismo_constructor> Lugares;
    public static  List<Turismo_constructor> Copia_Lugares;
    public int seleccion=0;
    private Firebase FBData;
    adaptador_turismo adapter;
    private static Spinner tipo;
    public  int contador=0;
    //private  static final String FirebaseUrl="https://turismo-a3b2c.firebaseio.com/";
    private  static final String FirebaseUrl="https://aves-87563.firebaseio.com/turismo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turismo);


        rv = (RecyclerView) findViewById(R.id.lista_turismo);
        rv.setLayoutManager(new LinearLayoutManager(this));
        Lugares = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        adapter= new adaptador_turismo(Lugares);
        rv.setAdapter(adapter);


        tipo = (Spinner) findViewById(R.id.sp_sitios);
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.sitios_array, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo.setAdapter(adaptador);
        tipo.setOnItemSelectedListener(this);


        database.getReferenceFromUrl(FirebaseUrl).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Lugares.removeAll(Lugares);

                for (DataSnapshot snapchat:dataSnapshot.getChildren()) {
                    Turismo_constructor lugar=snapchat.getValue(Turismo_constructor.class);
                    lugar.setKeyName(snapchat.getKey());
                    Lugares.add(lugar);
                }
                Copia_Lugares = new ArrayList<>();
                Copia_Lugares.addAll(Lugares);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num =rv.getChildAdapterPosition(v);
                //String msg="se presionó  "+ Integer.toString(num);
                //Toast.makeText(Turismo.this,msg, Toast.LENGTH_SHORT).show();
                lanzarLugarTurismo(v,num);
            }
        });

    }

    public void lanzarLugarTurismo(View view, int pos){
        Intent i = new Intent(this, Turismo_info.class);
        i.putExtra("id", pos);
        startActivity(i);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        seleccion=position;
        contador++;
       // String msg="se presionó  "+ Integer.toString(seleccion);
       // Toast.makeText(Turismo.this,msg, Toast.LENGTH_SHORT).show();

        if(seleccion > 0 && seleccion < 16) {

            //Copia_Lugares.addAll(Lugares);
            Lugares.removeAll(Lugares);
            for (int i =0 ; i < Copia_Lugares.size();i++)

            {
                int t =Copia_Lugares.get(i).getTipo();
                if(t == seleccion)
                {
                    Lugares.add(Copia_Lugares.get(i));
                }
            }

            if(Lugares.isEmpty() )
            {
                String msg_2= getString(R.string.no_sitio) ;
                Toast.makeText(Turismo.this,msg_2, Toast.LENGTH_LONG).show();

            }
            adapter.notifyDataSetChanged();
        }
       else if (contador > 1 || seleccion == 16)
        {
            CargarTodo();
        }


    }


 void CargarTodo()
 {
     Lugares.removeAll(Lugares);
     for (int i =0 ; i < Copia_Lugares.size();i++)
         Lugares.add(Copia_Lugares.get(i));

     adapter.notifyDataSetChanged();
 }




    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}





