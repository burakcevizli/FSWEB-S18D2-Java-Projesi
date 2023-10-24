package com.example.workintech.FruitsVegetables.services;


import com.example.workintech.FruitsVegetables.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    List<Vegetable> findAll();
    Vegetable find(long id);
    Vegetable save(Vegetable vegetable);
    Vegetable delete(long id);
    List<Vegetable> listByPriceDESC();
    List<Vegetable> listByPriceASC();
    List<Vegetable> listByName(String name);
}
