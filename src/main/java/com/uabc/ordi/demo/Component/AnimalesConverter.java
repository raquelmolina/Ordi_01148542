package com.uabc.ordi.demo.Component;

import com.uabc.ordi.demo.Entity.Animales;
import com.uabc.ordi.demo.Entity.Imagenes;
import com.uabc.ordi.demo.Entity.TipoAnimal;
import com.uabc.ordi.demo.Model.AnimalesModel;
import com.uabc.ordi.demo.Repository.ImagenesRepository;
import com.uabc.ordi.demo.Repository.TipoAnimalRepository;
import com.uabc.ordi.demo.Repository.TipoRazaRepository;
import com.uabc.ordi.demo.Entity.TipoRaza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component("animalesConverter")
public class AnimalesConverter {
    @Autowired
    @Qualifier("tipoRazaRepository")
    private TipoRazaRepository tipoRazaRepository;

    @Autowired
    @Qualifier("tipoAnimalRepository")
    private TipoAnimalRepository tipoAnimalRepository;


    public Animales convertirAnimalesModelaAnimales(AnimalesModel animalesModel) throws Exception {
        Animales animales = new Animales();
        animales.setIdAnimal(animalesModel.getIdAnimal());
        animales.setNombre(animalesModel.getNombre());
        String[] dates = animalesModel.getFechaNac().split("T");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dates[0]);
        animales.setFechaNac(date);
        String[] dates2 = animalesModel.getFechaAdop().split("T");
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dates2[0]);
        animales.setFechaAdop(date2);
        TipoRaza tipoRaza = tipoRazaRepository.findByIdRazaAnimal(animalesModel.getIdRazaAnimal());
        animales.setIdRazaAnimal(tipoRaza);
        TipoAnimal tipoAnimal = tipoAnimalRepository.findByIdTipoAnimal(animalesModel.getIdtipoAnimal());
        animales.setIdtipoAnimal(tipoAnimal);
        return animales;
    }

    public AnimalesModel convertirAnimalesaAnimalesModel(Animales animales){
        AnimalesModel animalesModel = new AnimalesModel();
        animalesModel.setIdAnimal(animales.getIdAnimal());
        animalesModel.setNombre(animales.getNombre());
        animalesModel.setFechaNac(animales.getFechaNac().toString());
        animalesModel.setFechaAdop(animales.getFechaAdop().toString());
        animalesModel.setIdRazaAnimal(animales.getIdRazaAnimal().getIdRazaAnimal());
        animalesModel.setIdtipoAnimal(animales.getIdtipoAnimal().getIdTipoAnimal());
        return animalesModel;
    }

}
