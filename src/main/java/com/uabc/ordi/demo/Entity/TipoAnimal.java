package com.uabc.ordi.demo.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tipo_animal")
public class TipoAnimal {
    @Id
    @GeneratedValue
    @Column(name="id_tipoAnimal")
    private int idTipoAnimal;
    @Column(name="tipoAnimal")
    private String tipo;

    public TipoAnimal() {

    }
}
