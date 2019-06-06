package com.uabc.ordi.demo.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="animales")
public class Animales {

    @Id
    @Column(name = "id_animal", unique = true, nullable = false)
    private String idAnimal;
    @Column(name="nombre")
    private String nombre;
    @Column(name = "fechaNacimiento")
    private Date fechaNac;
    @Column (name = "fechaAdopcion")
    private Date fechaAdop;
    @OneToOne
    @JoinColumn(name="id_tipoAnimal")
    private TipoAnimal idtipoAnimal;
    @OneToOne
    @JoinColumn(name="id_razaAnimal")
    private TipoRaza idRazaAnimal;
    @OneToOne
    @JoinColumn(name="id_imagen")
    private Imagenes idImagen;


    public Animales() {

    }
}
