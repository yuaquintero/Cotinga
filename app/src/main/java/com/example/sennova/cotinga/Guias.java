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

public class Guias extends AppCompatActivity {

    RecyclerView rv;
    public static List<Guias_constructor> Guias;
    private Firebase FBData;
    adaptador_guias adapter;
    private  static final String FirebaseUrl="https://aves-87563.firebaseio.com/guias";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guias);

        rv = (RecyclerView) findViewById(R.id.lista_guias);
        rv.setLayoutManager(new LinearLayoutManager(this));
        Guias = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        adapter= new adaptador_guias(Guias);
        rv.setAdapter(adapter);


        database.getReferenceFromUrl(FirebaseUrl).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Guias.removeAll(Guias);

                for (DataSnapshot snapchat:dataSnapshot.getChildren()) {
                    Guias_constructor guias=snapchat.getValue(Guias_constructor.class);
                    guias.setKeyName(snapchat.getKey());
                    Guias.add(guias);
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
               // String msg="se presionó  "+ Integer.toString(num);
                //Toast.makeText(Guias.this,msg, Toast.LENGTH_SHORT).show();
                lanzarLugarTurismo(v,num);
            }
        });

    }

    public void lanzarLugarTurismo(View view, int pos){
        Intent i = new Intent(this, Guia_info.class);
        i.putExtra("id", pos);
        startActivity(i);

    }

}





