package com.example.workintech.FruitsVegetables.services;

import com.example.workintech.FruitsVegetables.entity.Fruit;

import java.util.List;

public interface FruitService {
    List<Fruit> findAll();
    Fruit find(long id);
    Fruit save(Fruit fruit);
    Fruit delete(long id);
    List<Fruit> listByPriceDESC();
    List<Fruit> listByPriceASC();
    List<Fruit> listByName(String name);

}
