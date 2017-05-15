package com.example.sennova.cotinga;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Permisos extends AppCompatActivity
        implements ActivityCompat.OnRequestPermissionsResultCallback {

    /*
        public static final Integer SOLICITAR_PERMISO_LLAMADAS = 0;
        private int permissionCheck;
        private View miLayout;
        private Activity miActividad;
        private String telefono;
        private String[] lista_correos;
        Snackbar miSnackBar;

        Permisos(){
            //constructor vacío por defecto.
        }

        Permisos(View layoutPadre, Activity actividadPadre){
            setView(layoutPadre);
            setActividad(actividadPadre);

            //definir un objeto snackBar para personalizarlo
            miSnackBar = Snackbar.make(miLayout,"", Snackbar.LENGTH_INDEFINITE);
            View view = miSnackBar.getView();
            // cambiar color del texto del botón de acción
            miSnackBar.setActionTextColor(Color.YELLOW);

        }

        public void setTelefono(String var_telefono){
            telefono = var_telefono;
        }

        public void setCorreo(String varCorreo){
            lista_correos = varCorreo.split(",");
        }

        public void setView(View varLayout){
            miLayout = varLayout;
        }

        public void setActividad(Activity varActividad){
            miActividad = varActividad;
        }

        //Validar los permisos, volver a solicitarlos y tratar de lanzar la actividad de la llamada
        public void LanzarLlamada(String num_tel) {
            setTelefono(num_tel);
            permissionCheck = ContextCompat.checkSelfPermission(miActividad, android.Manifest.permission.CALL_PHONE);
            if (permissionCheck == PackageManager.PERMISSION_DENIED)
            {
                //no hay permiso, mostrar un dialogo explicativo
                if (ActivityCompat.shouldShowRequestPermissionRationale(miActividad,
                        android.Manifest.permission.CALL_PHONE)) {

                    // Elemento Sanckbar coon opcion de boton <aceptar> para
                    // explicar la necesidad del permiso, en caso que haya sido negado.
                    miSnackBar.setText(miActividad.getString(R.string.confirmar_permiso));
                    miSnackBar.setAction("Ok", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ActivityCompat.requestPermissions(miActividad,
                                    new String[]{android.Manifest.permission.CALL_PHONE},
                                    SOLICITAR_PERMISO_LLAMADAS);
                        }
                    });
                    miSnackBar.show();
                } else {
                    // ir directo a la solicitud de permisos.
                    ActivityCompat.requestPermissions(miActividad,
                            new String[]{android.Manifest.permission.CALL_PHONE},
                            SOLICITAR_PERMISO_LLAMADAS);

                    // SOLICITAR_PERMISO_LLAMADAS es una constante
                    // de tipo entero (int) declarada al princicipio, guarda el resultado de la
                    // petición de permisos y lo entrega a onRequestPermissionsResult.
                }
            } else {
                //si ya está habilitado el permiso, se ejecuta la acción de llamar.
                HacerLlamada();
            }
        }

        public void HacerLlamada() {
            //Acción que lleva al marcador telefónico.
            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:" + telefono));
            miActividad.startActivity(i);
        }

        public void Lanzar_Email(String var_correo) {
            //Obtener los campos de correo:
            String text_asunto;
            String text_mensaje;

            setCorreo(var_correo);
            text_asunto = miActividad.getString(R.string.asunto_mail);
            text_mensaje = miActividad.getString(R.string.cuerpo_mail);
            //generar la acción y definir los extras.
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // sólo apps de tipo correo manejan este tipo de datos
            intent.putExtra(Intent.EXTRA_EMAIL, lista_correos);
            intent.putExtra(Intent.EXTRA_SUBJECT, text_asunto);
            intent.putExtra(Intent.EXTRA_TEXT, text_mensaje);
            //preguntar si existe una app para ejecutar la acción
            if (intent.resolveActivity(miActividad.getPackageManager()) != null) {
                miActividad.startActivity(intent);
            } else {
                miSnackBar.make(miLayout, miActividad.getString(R.string.error_mail),
                        Snackbar.LENGTH_SHORT)
                        .show();

            }

        }
    */
    //ID para reconocer el tipo de permiso solicitado
    public static final Integer SOLICITAR_PERMISO_LLAMADAS = 0;
    public static final Integer SOLICITAR_PERMISO_CAMARA = 1;
    private static String[] PERMISOS_CAMARA = {Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private int permissionCheck;
    private View miLayout;
    private Activity miActividad;
    private String telefono;
    private String[] lista_correos;
    Snackbar miSnackBar;

    Permisos() {
        //constructor vacío por defecto.
    }

    /**
     * @param layoutPadre
     * @param actividadPadre Constructor que requiere como parámetros el Layout y la actividad principal
     */
    Permisos(View layoutPadre, Activity actividadPadre) {
        setView(layoutPadre);
        setActividad(actividadPadre);

        //definir un objeto snackBar para personalizarlo
        miSnackBar = Snackbar.make(miLayout, "", Snackbar.LENGTH_INDEFINITE);
        View sb_view = miSnackBar.getView();

    }

    /**
     * @param var_telefono
     */
    public void setTelefono(String var_telefono) {
        telefono = var_telefono;
    }

    /**
     * @param varCorreo
     */
    public void setCorreo(String varCorreo) {
        lista_correos = varCorreo.split(",");
    }

    /**
     * @param varLayout
     */
    public void setView(View varLayout) {
        miLayout = varLayout;
    }

    /**
     * @param varActividad
     */
    public void setActividad(Activity varActividad) {
        miActividad = varActividad;
    }

    /**
     * @param num_tel Validar los permisos, volver a solicitarlos y tratar de lanzar la actividad de la llamada
     */
    public void LanzarLlamada(String num_tel) {
        setTelefono(num_tel);
        permissionCheck = ContextCompat.checkSelfPermission(miActividad, Manifest.permission.CALL_PHONE);
//Si la variable que entrega el numero de teléfono no está vacia: lanzar la solicitud de llamada
        if (num_tel.length() > 0) {
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                //no hay permiso, mostrar un dialogo explicativo
                if (ActivityCompat.shouldShowRequestPermissionRationale(miActividad,
                        Manifest.permission.CALL_PHONE)) {

                    // Elemento Sanckbar coon opcion de boton <aceptar> para
                    // explicar la necesidad del permiso, en caso que haya sido negado.
                    //personalizar color de texto y string a mostrar en el scackbar
                    miSnackBar.setActionTextColor(Color.YELLOW);
                    miSnackBar.setText(miActividad.getString(R.string.confirmar_permiso));
                    miSnackBar.setAction("Ok", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ActivityCompat.requestPermissions(miActividad,
                                    new String[]{Manifest.permission.CALL_PHONE},
                                    SOLICITAR_PERMISO_LLAMADAS);
                        }
                    });
                    miSnackBar.show();
                } else {
                    // ir directo a la solicitud de permisos.
                    ActivityCompat.requestPermissions(miActividad,
                            new String[]{Manifest.permission.CALL_PHONE},
                            SOLICITAR_PERMISO_LLAMADAS);

                    // SOLICITAR_PERMISO_LLAMADAS es una constante
                    // de tipo entero (int) declarada al princicipio, guarda el resultado de la
                    // petición de permisos y lo entrega al método onRequestPermissionsResult
                    // (en la actividad principal).
                }
            } else {
                //si ya está habilitado el permiso, se ejecuta la acción de llamar.
                HacerLlamada();
            }
        } else {
            //En caso que la variable del teléfono esté vacío
        }
    }

    /**
     * Método para lanzar el marcador telefónico.
     */
    public void HacerLlamada() {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:" + telefono));
        miActividad.startActivity(i);
    }

    /**
     * @param var_correo
     * @param origen     el parámetro origen diferencia cual es la actividad que lanza la solicitud
     *                   de correo: valoress de origen --> 0: turismo, 1: guias
     *                   Método para crear el cuerpo del correo y enviar la acción para crear un e-mail.
     */

    public void Lanzar_Email(String var_correo, int origen) {
        //Obtener los campos de correo:
        String text_asunto;
        String text_mensaje;
        setCorreo(var_correo);
        //En caso que la variable del correo NO esté vacía.
        if (var_correo.length() > 0) {
            if (origen == 0) {
                text_asunto = miActividad.getString(R.string.asunto_mail_turismo);
                text_mensaje = miActividad.getString(R.string.cuerpo_mail_turismo);
            } else {
                text_asunto = miActividad.getString(R.string.asunto_mail_guia);
                text_mensaje = miActividad.getString(R.string.cuerpo_mail_guia);
            }
            //generar la acción y definir los extras.
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // sólo apps de tipo correo manejan este tipo de datos
            intent.putExtra(Intent.EXTRA_EMAIL, lista_correos);
            intent.putExtra(Intent.EXTRA_SUBJECT, text_asunto);
            intent.putExtra(Intent.EXTRA_TEXT, text_mensaje);
            //preguntar si existe una app para ejecutar la acción
            if (intent.resolveActivity(miActividad.getPackageManager()) != null) {
                miActividad.startActivity(intent);
            } else {
                miSnackBar.make(miLayout, miActividad.getString(R.string.error_mail),
                        Snackbar.LENGTH_SHORT)
                        .show();

            }
        } else {
            //Opción en la cual el correo está vacio. mostrar mensaje de error ?
        }
    }

    public boolean ValidarCamara() {
        boolean permiso = false;
//        permissionCheck = ContextCompat.checkSelfPermission(miActividad, android.Manifest.permission.CAMERA);

        if (ContextCompat.checkSelfPermission(miActividad, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED
                || ContextCompat.checkSelfPermission(miActividad, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            //no hay permiso, mostrar un dialogo explicativo
            if (ActivityCompat.shouldShowRequestPermissionRationale(miActividad,
                    Manifest.permission.CAMERA)
                    || ActivityCompat.shouldShowRequestPermissionRationale(miActividad,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                // Elemento Sanckbar coon opcion de boton <aceptar> para
                // explicar la necesidad del permiso, en caso que haya sido negado.
                //personalizar color de texto y string a mostrar en el scackbar
                miSnackBar.setActionTextColor(Color.YELLOW);
                miSnackBar.setText(miActividad.getString(R.string.confirmar_permiso));
                miSnackBar.setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ActivityCompat.requestPermissions(miActividad,
                                PERMISOS_CAMARA,
                                SOLICITAR_PERMISO_CAMARA);
                    }
                });
                miSnackBar.show();
            } else {
                // ir directo a la solicitud de permisos.
                ActivityCompat.requestPermissions(miActividad,
                        PERMISOS_CAMARA,
                        SOLICITAR_PERMISO_CAMARA);

                // SOLICITAR_PERMISO_LLAMADAS es una constante
                // de tipo entero (int) declarada al princicipio, guarda el resultado de la
                // petición de permisos y lo entrega al método onRequestPermissionsResult
                // (en la actividad principal).
            }
        } else {
            //si ya está habilitado el permiso, se ejecuta la acción.
            permiso = true;
        }
        return permiso;
    }

    public static boolean ValidarPermisos(int[] grantResults) {
        // At least one result must be checked.
        if(grantResults.length < 1){
            return false;
        }

        // Verify that each required permission has been granted, otherwise return false.
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

}