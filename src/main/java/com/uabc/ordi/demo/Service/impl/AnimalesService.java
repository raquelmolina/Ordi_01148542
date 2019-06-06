package com.uabc.ordi.demo.Service.impl;

import com.uabc.ordi.demo.Entity.Animales;
import com.uabc.ordi.demo.Model.AnimalesModel;

import java.util.List;

public interface AnimalesService {
    public abstract AnimalesModel addAnimales(AnimalesModel animalesModel) throws Exception;

    public abstract List<AnimalesModel> listAllAnimales();

    public abstract Animales findAnimalesByIdAnimales(String idAnimal);

    public abstract void removerAnimal(String idAnimal);

    public abstract AnimalesModel findAnimalesByIdAnimalesModel(String idAnimal);
}
