package com.uabc.ordi.demo.Model;

import lombok.Data;

import java.util.Date;
@Data
public class AnimalesModel {
    private String idAnimal;
    private String nombre;
    private String fechaNac;
    private String fechaAdop;
    private int idtipoAnimal;
    private int idRazaAnimal;
    private int idImagen;

    public AnimalesModel(){

    }
}
