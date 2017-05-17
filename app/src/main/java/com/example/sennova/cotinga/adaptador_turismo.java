package com.example.sennova.cotinga;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class adaptador_turismo extends RecyclerView.Adapter<adaptador_turismo.MyViewHolder>implements View.OnClickListener {

    List< Turismo_constructor> Lugares;
    private View.OnClickListener listener;
    private ImageView ViewFoto;
    private static final String urlStorage="gs://aves-87563.appspot.com";
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef;
    private static  String FotoStore;




    // Create an ArrayAdapter using the string array and a default spinner layout

// Specify the layout to use when the list of choices appears



    static ArrayAdapter<CharSequence> adapter;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView NombreLugar;
        TextView EnlaceLugar;
        TextView DireccionLugar;
        ImageView FotoLugar;
        TextView Tvvaloracion;

        public MyViewHolder(View view) {
            super(view);
            NombreLugar = (TextView)itemView.findViewById(R.id.tVsitio);
            EnlaceLugar = (TextView)itemView.findViewById(R.id.tVpag);
            DireccionLugar = (TextView)itemView.findViewById(R.id.tVDsitio);
            FotoLugar = (ImageView)itemView.findViewById(R.id.iv_tur);
            Tvvaloracion=(TextView) itemView.findViewById(R.id.puntuacion);


        }
    }




    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.turismo_card, parent, false);
        itemView.setOnClickListener(this);
        MyViewHolder holder =new MyViewHolder(itemView);
        return holder;




    }


    public adaptador_turismo(List<Turismo_constructor> lugares) {
        this.Lugares = lugares;
    }


    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Turismo_constructor sitio =Lugares.get(position);
        holder.NombreLugar.setText(sitio.getNombre());
        holder.EnlaceLugar.setText(sitio.getEnlace());
        holder.DireccionLugar.setText(sitio.getDireccion());
        FotoStore=sitio.getFoto();
        storageRef= storage.getReferenceFromUrl(urlStorage).child(FotoStore);


        DecimalFormat df = new DecimalFormat("##.#");
        df.setRoundingMode(RoundingMode.DOWN);

        String valoracion=df.format(sitio.getValoracion());
       if( valoracion.length()==1)
            valoracion=valoracion+",0";

      //  holder.Tvvaloracion.setText(String.valueOf(sitio.getValoracion()));
        holder.Tvvaloracion.setText(valoracion);

        final long ONE_MEGABYTE = 1024 * 1024;
        storageRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                holder.FotoLugar.setImageBitmap(bitmap);
            }
        });




/*
        int id = R.drawable.otros;
        switch(sitio.getTipo()) {
            case 1:            id = R.drawable.restaurante;  break;
            case 2:            id = R.drawable.hotel;        break;
            case 3:            id = R.drawable.gasolinera;   break;
            case 4:            id = R.drawable.educacion;    break;
            case 5:            id = R.drawable.bar;          break;
            case 6:            id = R.drawable.historico;    break;
            case 7:            id = R.drawable.ecoturismo;   break;
            case 8:            id = R.drawable.comercial;    break;
            case 9:            id = R.drawable.religioso;     break;
            case 10:           id = R.drawable.z_wifi;       break;
            case 11:           id = R.drawable.deporte;      break;
            case 12:           id = R.drawable.salud;        break;
            case 13:           id = R.drawable.t_publico;    break;
            case 14:           id = R.drawable.r_indigena;   break;
            case 15:           id = R.drawable.z_financiera; break;

        }
        //holder.FotoLugar.setImageResource(id);*/
        holder.FotoLugar.setScaleType(ImageView.ScaleType.FIT_END);


    }

    @Override
    public int getItemCount() {
        return Lugares.size();
    }
}