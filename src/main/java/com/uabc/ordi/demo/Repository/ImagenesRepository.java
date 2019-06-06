package com.uabc.ordi.demo.Repository;


import com.uabc.ordi.demo.Entity.Imagenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

@Repository("imagenesRepository")
public interface ImagenesRepository extends JpaRepository<Imagenes, Serializable> {
    public abstract Imagenes findByIdImagen(int idImagen);
}
