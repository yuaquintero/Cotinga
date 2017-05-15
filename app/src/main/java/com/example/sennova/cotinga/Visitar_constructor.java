package com.example.sennova.cotinga;


public class Visitar_constructor {


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String foto) {
        this.imagen = foto;
    }

    public String getTipositio() {
        return tipositio;
    }

    public void setTipositio(String tipositio) {
        this.tipositio = tipositio;
    }

    private String nombre;
    private String link;
    private String descripcion;
    private String imagen;
    private String tipositio;


    public Visitar_constructor(){

    }

    public Visitar_constructor(String _nombre, String _link,  String _descripcion, String _imagen, String _tipositio) {
        this.nombre=_nombre;
        this.link=_link;
        this.descripcion=_descripcion;
        this.imagen=_imagen;
        this.tipositio=_tipositio;
    }



}

