package com.example.sennova.cotinga;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Recomendaciones extends AppCompatActivity {

    ImageButton r1,r2,r3,r4,r5,r6,r7,r8,r10;
    Integer bandera=0;

    /**
     * Clase encargada de mostrar las recomendaciones dadas al usuario de la app a traves de la implementación de 9 Imagebuttons
     * que despliegan ventanas emergentes segun la recomendación seleccionada
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomendaciones);



        r1 = (ImageButton) findViewById(R.id.r1);
        r2 = (ImageButton) findViewById(R.id.r2);
        r3 = (ImageButton) findViewById(R.id.r3);
        r4 = (ImageButton) findViewById(R.id.r4);
        r5 = (ImageButton) findViewById(R.id.r5);
        r6 = (ImageButton) findViewById(R.id.r6);
        r7 = (ImageButton) findViewById(R.id.r7);
        r8 = (ImageButton) findViewById(R.id.r8);
        r10 = (ImageButton) findViewById(R.id.r10);


        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bandera=1;
                openCustomDialog(view, bandera);
            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bandera=2;
                openCustomDialog(view, bandera);

            }
        });

        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bandera=3;
                openCustomDialog(view, bandera);

            }
        });

        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bandera=4;
                openCustomDialog(view, bandera);

            }
        });

        r5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bandera=5;
                openCustomDialog(view, bandera);

            }
        });

        r6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bandera=6;
                openCustomDialog(view, bandera);

            }
        });

        r7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bandera=7;
                openCustomDialog(view, bandera);

            }
        });

        r8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bandera=8;
                openCustomDialog(view, bandera);

            }
        });

        r10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bandera=9;
                openCustomDialog(view, bandera);

            }
        });
    }
    /**
     * Metodo que permite desplegar ventana emergente con la información solicitada
     * El metodo devuelve Recurso XML con la información de la opción solicitada
     *
     */
    public void openCustomDialog(View view, Integer b) {
        switch(b){

            case 1:
                final Dialog dialog1 = new Dialog(this);
                dialog1.setContentView(R.layout.reco1);
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                Button volver = (Button) dialog1.findViewById(R.id.volver);
                volver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }
                });
                dialog1.show();
                break;
            case 2:
                final Dialog dialog2 = new Dialog(this);
                dialog2.setContentView(R.layout.reco2);
                dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                Button volver2 = (Button) dialog2.findViewById(R.id.volver2);
                volver2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog2.dismiss();
                    }
                });
                dialog2.show();
                break;
            case 3:
                final Dialog dialog3 = new Dialog(this);
                dialog3.setContentView(R.layout.reco3);
                dialog3.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                Button volver3 = (Button) dialog3.findViewById(R.id.volver3);
                volver3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog3.dismiss();
                    }
                });
                dialog3.show();
                break;
            case 4:
                final Dialog dialog4 = new Dialog(this);
                dialog4.setContentView(R.layout.reco4);
                dialog4.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                Button volver4 = (Button) dialog4.findViewById(R.id.volver4);
                volver4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog4.dismiss();
                    }
                });
                dialog4.show();
                break;
            case 5:
                final Dialog dialog5 = new Dialog(this);
                dialog5.setContentView(R.layout.reco5);
                dialog5.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                Button volver5 = (Button) dialog5.findViewById(R.id.volver5);
                volver5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog5.dismiss();
                    }
                });
                dialog5.show();
                break;
            case 6:
                final Dialog dialog6 = new Dialog(this);
                dialog6.setContentView(R.layout.reco6);
                dialog6.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                Button volver6 = (Button) dialog6.findViewById(R.id.volver6);
                volver6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog6.dismiss();
                    }
                });
                dialog6.show();
                break;
            case 7:
                final Dialog dialog7 = new Dialog(this);
                dialog7.setContentView(R.layout.reco7);
                dialog7.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                Button volver7 = (Button) dialog7.findViewById(R.id.volver7);
                volver7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog7.dismiss();
                    }
                });
                dialog7.show();
                break;
            case 8:
                final Dialog dialog8 = new Dialog(this);
                dialog8.setContentView(R.layout.reco8);
                dialog8.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                Button volver8 = (Button) dialog8.findViewById(R.id.volver8);
                volver8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog8.dismiss();
                    }
                });
                dialog8.show();
                break;
            case 9:
                final Dialog dialog9 = new Dialog(this);
                dialog9.setContentView(R.layout.reco9);
                dialog9.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                Button volver9 = (Button) dialog9.findViewById(R.id.volver9);
                volver9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog9.dismiss();
                    }
                });
                dialog9.show();
                break;

        }

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
                Intent Home = new Intent(Recomendaciones.this, Home.class);
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
