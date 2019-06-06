package com.uabc.ordi.demo.Service.impl;

import com.uabc.ordi.demo.Component.AnimalesConverter;
import com.uabc.ordi.demo.Entity.Animales;
import com.uabc.ordi.demo.Model.AnimalesModel;
import com.uabc.ordi.demo.Repository.AnimalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("animalesServiceImpl")
public class AnimalesServiceImpl implements AnimalesService{
    @Autowired
    @Qualifier("animalesRepository")
    AnimalesRepository animalesRepository;

    @Autowired
    @Qualifier("animalesConverter")
    AnimalesConverter animalesConverter;

    @Override
    public AnimalesModel addAnimales(AnimalesModel animalesModel) throws Exception{
        Animales temp = animalesConverter.convertirAnimalesModelaAnimales(animalesModel);
        Animales animales = animalesRepository.save(temp);
        return animalesConverter.convertirAnimalesaAnimalesModel(animales);
    }

    @Override
    public List<AnimalesModel> listAllAnimales() {
        List<Animales> animales = animalesRepository.findAll();
        List<AnimalesModel> animalesModels = new ArrayList();
        for(Animales animal : animales)
            animalesModels.add(animalesConverter.convertirAnimalesaAnimalesModel(animal));
        return animalesModels;
    }

    @Override
    public Animales findAnimalesByIdAnimales(String idAnimal) {
        return animalesRepository.findByIdAnimal(idAnimal);
    }

    @Override
    public void removerAnimal(String idAnimal) {
        Animales animales = findAnimalesByIdAnimales(idAnimal);
        if(animales!=null)
            animalesRepository.delete(findAnimalesByIdAnimales(idAnimal));

    }


    @Override
    public AnimalesModel findAnimalesByIdAnimalesModel(String idAnimal) {
        return  animalesConverter.convertirAnimalesaAnimalesModel(findAnimalesByIdAnimales(idAnimal));

    }


}
