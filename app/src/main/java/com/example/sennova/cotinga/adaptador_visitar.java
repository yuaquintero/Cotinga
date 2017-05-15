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

public class adaptador_visitar extends RecyclerView.Adapter<adaptador_visitar.MyViewHolder3>implements View.OnClickListener {


    List< Visitar_constructor> Visitas;
    private View.OnClickListener listener;
    private static final String urlStorage="gs://aves-87563.appspot.com";
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef;
    private static  String FotoStore;

    public adaptador_visitar(List<Visitar_constructor> visitas) {
        this.Visitas = visitas;
    }


    public static class MyViewHolder3 extends RecyclerView.ViewHolder {
        TextView NombreSitio;
        TextView TipoSitio;
        ImageView FotoSitio;
        public RatingBar valoracion;

        public MyViewHolder3(View view) {
            super(view);

            NombreSitio = (TextView)itemView.findViewById(R.id.tvNombreVisitar);
            TipoSitio = (TextView)itemView.findViewById(R.id.tvTipoVisitar);
            FotoSitio = (ImageView)itemView.findViewById(R.id.ivVisitar);
        }
    }

    @Override
    public adaptador_visitar.MyViewHolder3 onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.visitar_card, parent, false);
        itemView.setOnClickListener(this);
        adaptador_visitar.MyViewHolder3 holder =new adaptador_visitar.MyViewHolder3(itemView);
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
    public void onBindViewHolder(final adaptador_visitar.MyViewHolder3 holder, int position) {
        Visitar_constructor guia =Visitas.get(position);
        holder.NombreSitio.setText(guia.getNombre());
        holder.TipoSitio.setText(guia.getTipositio());

        FotoStore=guia.getImagen();
        storageRef= storage.getReferenceFromUrl(urlStorage).child(FotoStore);

        final long ONE_MEGABYTE = 1024 * 1024;
        storageRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                holder.FotoSitio.setImageBitmap(bitmap);
            }
        });

        //holder.FotoSitio.setImageResource(R.drawable.ave_1);
        holder.FotoSitio.setScaleType(ImageView.ScaleType.FIT_END);
    }

    @Override
    public int getItemCount() {
        return Visitas.size();
    }

}
