package com.example.sennova.cotinga;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

//https://aves-87563.firebaseio.com/guias
public class adaptador_guias extends RecyclerView.Adapter<adaptador_guias.MyViewHolder2>implements View.OnClickListener {

    List< Guias_constructor> Guias;
    private View.OnClickListener listener;
    private static final String urlStorage="gs://aves-87563.appspot.com";
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef;
    private static  String FotoStore;
    public adaptador_guias(List<Guias_constructor> guias) {
        this.Guias = guias;
    }


    public static class MyViewHolder2 extends RecyclerView.ViewHolder {
        TextView NombreGuia;
        TextView TelefonoGuia;
        ImageView FotoGuia;
        public RatingBar valoracion;

        public MyViewHolder2(View view) {
            super(view);
            NombreGuia = (TextView)itemView.findViewById(R.id.nombreguia);
            FotoGuia = (ImageView)itemView.findViewById(R.id.iv_tur2);
            TelefonoGuia = (TextView)itemView.findViewById(R.id.telguia);
        }
    }




    @Override
    public adaptador_guias.MyViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.guias_card, parent, false);
        itemView.setOnClickListener(this);
        adaptador_guias.MyViewHolder2 holder =new adaptador_guias.MyViewHolder2(itemView);
        return holder;

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
    public void onBindViewHolder(final adaptador_guias.MyViewHolder2 holder, int position) {
        Guias_constructor guia =Guias.get(position);
        holder.NombreGuia.setText(guia.getNombre());
        holder.TelefonoGuia.setText(String.valueOf(guia.getTelefono()));

        FotoStore=guia.getFoto();
        storageRef= storage.getReferenceFromUrl(urlStorage).child(FotoStore);

        final long ONE_MEGABYTE = 1024 * 1024;

        storageRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                holder.FotoGuia.setImageBitmap(bitmap);
            }
        });

        holder.FotoGuia.setScaleType(ImageView.ScaleType.FIT_END);


    }

    @Override
    public int getItemCount() {
        return Guias.size();
    }





















}
