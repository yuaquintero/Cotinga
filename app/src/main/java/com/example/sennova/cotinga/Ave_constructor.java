package com.example.sennova.cotinga;
/**
 * Esta clase sirve como molde del cardview que desplegará la información general de las aves
 */
public class Ave_constructor {

    String nombre1, nombre2,nombre3,nombre4;
    Integer id;

    public Ave_constructor(){

    }

    public Ave_constructor(String nombre1, String nombre2 , String nombre3,String nombre4,Integer id) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.nombre3 = nombre3;
        this.nombre4 = nombre4;
        this.id=id;
    }


}
