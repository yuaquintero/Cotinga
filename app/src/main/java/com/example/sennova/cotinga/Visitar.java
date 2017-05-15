package com.example.sennova.cotinga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Visitar extends AppCompatActivity {

    RecyclerView rv;
    public static List<Visitar_constructor> Sitios;
    private Firebase FBData;
    adaptador_visitar adapter;
    //private  static final String FirebaseUrl="https://turismo-a3b2c.firebaseio.com/";
    private  static final String FirebaseUrl="https://aves-87563.firebaseio.com/interes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitar);

        rv = (RecyclerView) findViewById(R.id.lista_enlaces);
        rv.setLayoutManager(new LinearLayoutManager(this));
        Sitios = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        adapter= new adaptador_visitar(Sitios);
        rv.setAdapter(adapter);


        database.getReferenceFromUrl(FirebaseUrl).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Sitios.removeAll(Sitios);

                for (DataSnapshot snapchat:dataSnapshot.getChildren()) {
                    Visitar_constructor lugar=snapchat.getValue(Visitar_constructor.class);
                    Sitios.add(lugar);
                }
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
                //Toast.makeText(Visitar.this,msg, Toast.LENGTH_SHORT).show();
                lanzarSitio(v,num);
            }
        });

    }

    public void lanzarSitio(View view, int pos){
        Intent i = new Intent(this, Visitar_info.class);
        i.putExtra("id", pos);
        startActivity(i);

    }

}





