package com.uabc.ordi.demo.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="imagenes")
public class Imagenes {
    @Id
    @GeneratedValue
    @Column(name="id_imagen")
    private int idImagen;
    @Column(name = "URL")
    private String url;

    public Imagenes(){

    }
}
