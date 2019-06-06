package com.uabc.ordi.demo.Repository;

import com.uabc.ordi.demo.Entity.TipoRaza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository("tipoRazaRepository")
public interface TipoRazaRepository extends JpaRepository<TipoRaza, Serializable> {
    public abstract TipoRaza findByIdRazaAnimal(int idAnimal);
}
