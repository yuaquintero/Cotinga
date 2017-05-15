package com.example.sennova.cotinga;


public class Guias_constructor {



    private String nombre;
    //private String direccion;
    //private String servicios;
    private long telefono;
    private String email;
    //private String  distancia;
    //private String ruta;
    private String foto;
    private double  valoracion;
    private String comentario;
    private double contador;
    private String enlace;
    private String keyName;
    //private int tipo;

    public Guias_constructor(){

    }


    public Guias_constructor(String _nombre, int  _telefono,  String _email, long _contador,String _foto, double  _valoracion, String _comentario, String _enlace) {

        this.nombre=_nombre;
        //this.tipo= _tipo;
        this.telefono=_telefono;
        this.email=_email;
        //this.foto=_foto;
        this.valoracion=_valoracion;
        this.contador = _contador;
        this.comentario = _comentario;
        this.enlace = _enlace;


    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getNombre() {
        return nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long  getTelefono() {
        return telefono;
    }

    public void setTelefono(long  telefono) {
        this.telefono = telefono;
    }

    public double  getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getContador() {
        return contador;
    }

    public void setContador(double contador) {
        this.contador = contador;
    }

    public String getEnlace(){
        return enlace;
    }

    public  void setEnlace(String enlace){
        this.enlace = enlace;
    }

    public String getKeyName(){
        return keyName;
    }

    public void setKeyName(String keyName){
        this.keyName = keyName;
    }



}

