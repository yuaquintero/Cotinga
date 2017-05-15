package com.example.sennova.cotinga;

public class Turismo_constructor {

    private String nombre;
    private String direccion;
    private String servicios;
    private long telefono;
    private String email;
    private String  distancia;
    private String ruta;
    private double  lat;
    private double  lon;
    private String foto;
    private double  valoracion;
    private String comentario;
    private String enlace;
    private int tipo;
    private String keyName;
    private double contador;

    public Turismo_constructor(){

    }


    public Turismo_constructor(String _nombre, String _direccion, int  _telefono,  String _email, String  _distancia, String _ruta, int _tipo, double  _lat, double  _lon,
                               String _foto, double  _valoracion, String _comentario,String _enlace, double _contador) {

        this.nombre=_nombre;
        this.direccion=_direccion;
        this.tipo= _tipo;
        this.telefono=_telefono;
        this.email=_email;
        this.distancia=_distancia;
        this.ruta=_ruta;
        this.lat=_lat;
        this.lon=_lon;
        this.foto=_foto;
        this.valoracion=_valoracion;
        this.comentario=_comentario;
        this.enlace=_enlace;
        this.contador=_contador;

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String  getServicios() {
        return servicios;
    }

    public void setServicios(String  servicios) {
        this.servicios = servicios;
    }

    public long  getTelefono() {
        return telefono;
    }

    public void setTelefono(long  telefono) {
        this.telefono = telefono;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String  distancia) {
        this.distancia = distancia;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public double  getLat() {
        return lat;
    }

    public void setLat(double  lat) {
        this.lat = lat;
    }

    public double  getLon() {
        return lon;
    }

    public void setLon(double  lon) {
        this.lon = lon;
    }

    public double  getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public int getTipo() {return tipo;}

    public void setTipo(int tipo) {this.tipo = tipo;}

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }



    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public double getContador() {
        return contador;
    }

    public void setContador(double contador) {
        this.contador = contador;
    }





}
