package com.uabc.ordi.demo.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tipo_raza")
public class TipoRaza {
    @Id
    @GeneratedValue
    @Column(name="id_idRazaAnimal")
    private int idRazaAnimal;
    @Column(name="tipoRAZA")
    private String tipoRaza;

    public TipoRaza() {

    }
}
