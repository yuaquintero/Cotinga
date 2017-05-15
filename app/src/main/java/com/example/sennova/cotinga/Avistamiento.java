package com.example.sennova.cotinga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class Avistamiento extends AppCompatActivity {

    Button bFiltrar;
    String colorPrimario, colorSecundario, formaAve, formaPico;
    RadioGroup rgCriterio1, rgCriterio2, rgCriterio4, rgCriterio5;
    ImageView ivCriterio1, ivCriterio2, ivCriterio4, ivCriterio5 ;
    LinearLayout formitas,piquitos,colorsitos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avistamiento);

        rgCriterio1=(RadioGroup) findViewById(R.id.radioGroup1);
        ivCriterio1=(ImageView) findViewById(R.id.ivColor1);
        rgCriterio2=(RadioGroup) findViewById(R.id.radioGroup2);
        ivCriterio2=(ImageView) findViewById(R.id.ivColor2);
        formitas=(LinearLayout)findViewById(R.id.formas1);
        piquitos=(LinearLayout)findViewById(R.id.picos1);
        colorsitos=(LinearLayout)findViewById(R.id.colores1);

        rgCriterio4=(RadioGroup) findViewById(R.id.radioGroup4);
        ivCriterio4=(ImageView) findViewById(R.id.ivPico);

        rgCriterio5=(RadioGroup) findViewById(R.id.radioGroup5);
        ivCriterio5=(ImageView) findViewById(R.id.ivAve);

        bFiltrar = (Button) findViewById(R.id.bFiltrar);

        /*formitas.setVisibility(View.GONE);
        piquitos.setVisibility(View.GONE);
        colorsitos.setVisibility(View.GONE);*/


        rgCriterio1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbNinguno1){
                    ivCriterio1.setImageResource(R.drawable.colorful);
                    colorPrimario="0";
                }else if (checkedId == R.id.rbAmarillo1){
                    ivCriterio1.setImageResource(R.drawable.color_amarillo);
                    colorPrimario="1";
                }else if (checkedId == R.id.rbAzul1){
                    ivCriterio1.setImageResource(R.drawable.color_azul);
                    colorPrimario="2";
                }else if (checkedId == R.id.rbBlanco1){
                    ivCriterio1.setImageResource(R.drawable.color_blanco);
                    colorPrimario="3";
                }else if (checkedId == R.id.rbCafe1){
                    ivCriterio1.setImageResource(R.drawable.color_cafe);
                    colorPrimario="4";
                }else if (checkedId == R.id.rbDorado1){
                    ivCriterio1.setImageResource(R.drawable.color_dorado);
                    colorPrimario="5";
                }else if (checkedId == R.id.rbGris1){
                    ivCriterio1.setImageResource(R.drawable.color_gris);
                    colorPrimario="6";
                }else if (checkedId == R.id.rbMorado1){
                    ivCriterio1.setImageResource(R.drawable.color_morado);
                    colorPrimario="7";
                }else if (checkedId == R.id.rbNaranja1){
                    ivCriterio1.setImageResource(R.drawable.color_naranja);
                    colorPrimario="8";
                }else if (checkedId == R.id.rbNegro1){
                    ivCriterio1.setImageResource(R.drawable.color_negro);
                    colorPrimario="9";
                }else if (checkedId == R.id.rbPardo1){
                    ivCriterio1.setImageResource(R.drawable.color_pardo);
                    colorPrimario="10";
                }else if (checkedId == R.id.rbRojo1){
                    ivCriterio1.setImageResource(R.drawable.color_rojo);
                    colorPrimario="11";
                }else if (checkedId == R.id.rbRosado1){
                    ivCriterio1.setImageResource(R.drawable.color_rosado);
                    colorPrimario="12";
                }else if (checkedId == R.id.rbRufo1){
                    ivCriterio1.setImageResource(R.drawable.color_rufo);
                    colorPrimario="13";
                }else if (checkedId == R.id.rbTurquesa1){
                    ivCriterio1.setImageResource(R.drawable.color_turquesa);
                    colorPrimario="14";
                }else if (checkedId == R.id.rbVerde1){
                    ivCriterio1.setImageResource(R.drawable.color_verde);
                    colorPrimario="15";
                }else if (checkedId == R.id.rbVioleta1){
                    ivCriterio1.setImageResource(R.drawable.color_violeta);
                    colorPrimario="16";
                }else if (checkedId == R.id.rbBeige1){
                    ivCriterio1.setImageResource(R.drawable.color_beige);
                    colorPrimario="17";
                }else if (checkedId == R.id.rbOliva1){
                    ivCriterio1.setImageResource(R.drawable.color_oliva);
                    colorPrimario="18";
                }
            }
        });

        rgCriterio2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbNinguno2){
                    ivCriterio2.setImageResource(R.drawable.colorful);
                    colorSecundario="0";
                }else if (checkedId == R.id.rbAmarillo2){
                    ivCriterio2.setImageResource(R.drawable.color_amarillo);
                    colorSecundario="1";
                }else if (checkedId == R.id.rbAzul2){
                    ivCriterio2.setImageResource(R.drawable.color_azul);
                    colorSecundario="2";
                }else if (checkedId == R.id.rbBlanco2){
                    ivCriterio2.setImageResource(R.drawable.color_blanco);
                    colorSecundario="3";
                }else if (checkedId == R.id.rbCafe2){
                    ivCriterio2.setImageResource(R.drawable.color_cafe);
                    colorSecundario="4";
                }else if (checkedId == R.id.rbDorado2){
                    ivCriterio2.setImageResource(R.drawable.color_dorado);
                    colorSecundario="5";
                }else if (checkedId == R.id.rbGris2){
                    ivCriterio2.setImageResource(R.drawable.color_gris);
                    colorSecundario="6";
                }else if (checkedId == R.id.rbMorado2){
                    ivCriterio2.setImageResource(R.drawable.color_morado);
                    colorSecundario="7";
                }else if (checkedId == R.id.rbNaranja2){
                    ivCriterio2.setImageResource(R.drawable.color_naranja);
                    colorSecundario="8";
                }else if (checkedId == R.id.rbNegro2){
                    ivCriterio2.setImageResource(R.drawable.color_negro);
                    colorSecundario="9";
                }else if (checkedId == R.id.rbPardo2){
                    ivCriterio2.setImageResource(R.drawable.color_pardo);
                    colorSecundario="10";
                }else if (checkedId == R.id.rbRojo2){
                    ivCriterio2.setImageResource(R.drawable.color_rojo);
                    colorSecundario="11";
                }else if (checkedId == R.id.rbRosado2){
                    ivCriterio2.setImageResource(R.drawable.color_rosado);
                    colorSecundario="12";
                }else if (checkedId == R.id.rbRufo2){
                    ivCriterio2.setImageResource(R.drawable.color_rufo);
                    colorSecundario="13";
                }else if (checkedId == R.id.rbTurquesa2){
                    ivCriterio2.setImageResource(R.drawable.color_turquesa);
                    colorSecundario="14";
                }else if (checkedId == R.id.rbVerde2){
                    ivCriterio2.setImageResource(R.drawable.color_verde);
                    colorSecundario="15";
                }else if (checkedId == R.id.rbVioleta2){
                    ivCriterio2.setImageResource(R.drawable.color_violeta);
                    colorSecundario="16";
                }else if (checkedId == R.id.rbBeige2){
                    ivCriterio2.setImageResource(R.drawable.color_beige);
                    colorSecundario="17";
                }else if (checkedId == R.id.rbOliva2){
                    ivCriterio2.setImageResource(R.drawable.color_oliva);
                    colorSecundario="18";
                }
            }
        });

        rgCriterio4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbNinguno4){
                    ivCriterio4.setImageResource(R.drawable.botonaves);
                    formaPico="0";
                }else if (checkedId == R.id.rbPico1){
                    ivCriterio4.setImageResource(R.drawable.pico1);
                    formaPico="1";
                }else if (checkedId == R.id.rbPico2){
                    ivCriterio4.setImageResource(R.drawable.pico2);
                    formaPico="2";
                }else if (checkedId == R.id.rbPico3){
                    ivCriterio4.setImageResource(R.drawable.pico3);
                    formaPico="3";
                }else if (checkedId == R.id.rbPico4){
                    ivCriterio4.setImageResource(R.drawable.pico4);
                    formaPico="4";
                }else if (checkedId == R.id.rbPico5){
                    ivCriterio4.setImageResource(R.drawable.pico5);
                    formaPico="5";
                }else if (checkedId == R.id.rbPico6){
                    ivCriterio4.setImageResource(R.drawable.pico6);
                    formaPico="6";
                }else if (checkedId == R.id.rbPico7){
                    ivCriterio4.setImageResource(R.drawable.pico7);
                    formaPico="7";
                }else if (checkedId == R.id.rbPico8){
                    ivCriterio4.setImageResource(R.drawable.pico8);
                    formaPico="8";
                }else if (checkedId == R.id.rbPico9){
                    ivCriterio4.setImageResource(R.drawable.pico9);
                    formaPico="9";
                }
            }
        });

        rgCriterio5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbNinguno5){
                    ivCriterio5.setImageResource(R.drawable.botonaves);
                    formaAve="0";
                }else if (checkedId == R.id.rbAve1){
                    ivCriterio5.setImageResource(R.drawable.forma1);
                    formaAve="1";
                }else if (checkedId == R.id.rbAve2){
                    ivCriterio5.setImageResource(R.drawable.forma2);
                    formaAve="2";
                }else if (checkedId == R.id.rbAve3){
                    ivCriterio5.setImageResource(R.drawable.forma3);
                    formaAve="3";
                }else if (checkedId == R.id.rbAve4){
                    ivCriterio5.setImageResource(R.drawable.forma4);
                    formaAve="4";
                }else if (checkedId == R.id.rbAve5){
                    ivCriterio5.setImageResource(R.drawable.forma5);
                    formaAve="5";
                }else if (checkedId == R.id.rbAve6){
                    ivCriterio5.setImageResource(R.drawable.forma6);
                    formaAve="6";
                }else if (checkedId == R.id.rbAve7){
                    ivCriterio5.setImageResource(R.drawable.forma7);
                    formaAve="7";
                }else if (checkedId == R.id.rbAve8){
                    ivCriterio5.setImageResource(R.drawable.forma8);
                    formaAve="8";
                }else if (checkedId == R.id.rbAve9){
                    ivCriterio5.setImageResource(R.drawable.forma9);
                    formaAve="9";
                }
            }
        });


        bFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent explicit_intent;
                explicit_intent = new Intent(Avistamiento.this,Filtro.class);

                if(view==bFiltrar){

                    explicit_intent.putExtra("colorPrimario",colorPrimario);
                    explicit_intent.putExtra("colorSecundario",colorSecundario);
                    explicit_intent.putExtra("formaPico",formaPico);
                    explicit_intent.putExtra("formaAve",formaAve);

                    startActivity(explicit_intent);
                }


            }
        });

    }
   /* public void toggle_contents_anim(View v){
        if(formitas.isShown()){
            slide_up(this,formitas);
            formitas.setVisibility(View.GONE);
        }
        else{

            formitas.setVisibility(View.VISIBLE);
            slide_down(this,formitas);
        }
    }
    public void toggle_contents_anim2(View v){

        if(piquitos.isShown()){
            slide_up(this,piquitos);
            piquitos.setVisibility(View.GONE);
        }
        else{
            piquitos.setVisibility(View.VISIBLE);
            slide_down(this,piquitos);
        }

    }
    public void toggle_contents_anim3(View v){
        if(colorsitos.isShown()){
            slide_up(this,colorsitos);
            colorsitos.setVisibility(View.GONE);
        }
        else{
            colorsitos.setVisibility(View.VISIBLE);
            slide_down(this,colorsitos);
        }
    }
    public static void slide_up(Context ctx, View v){
        Animation b= AnimationUtils.loadAnimation(ctx,R.anim.slide_up);
        if(b != null){
            b.reset();
            if(v != null){
                v.clearAnimation();
                v.startAnimation(b);
            }
        }
    }
    public static void slide_down(Context ctx, View v){
        Animation a= AnimationUtils.loadAnimation(ctx,R.anim.slide_down);
        if(a != null){

            a.reset();
            if(v != null){
                v.clearAnimation();
                v.startAnimation(a);
            }
        }
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent avistar = new Intent(this, Home.class);
        startActivity(avistar);
    }*/




}
