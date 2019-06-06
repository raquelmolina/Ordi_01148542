package com.uabc.ordi.demo.Repository;

import com.uabc.ordi.demo.Entity.Animales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("animalesRepository")
public interface AnimalesRepository extends JpaRepository<Animales,Serializable>{
        public abstract Animales findByIdAnimal(String idAnimal);
}

