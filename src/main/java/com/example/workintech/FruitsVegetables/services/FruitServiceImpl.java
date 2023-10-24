package com.example.workintech.FruitsVegetables.services;

import com.example.workintech.FruitsVegetables.dao.FruitRepository;
import com.example.workintech.FruitsVegetables.entity.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{

    private FruitRepository fruitRepository;
    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit find(long id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if(fruitOptional.isPresent()){
            return fruitOptional.get();
        }
        return null;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(long id) {
        Fruit fruit = find(id);
        fruitRepository.delete(fruit);
        return fruit;
    }

    @Override
    public List<Fruit> listByPriceDESC() {
        return fruitRepository.listByPriceDESC();
    }

    @Override
    public List<Fruit> listByPriceASC() {
        return fruitRepository.listByPriceASC();
    }


    @Override
    public List<Fruit> listByName(String name) {
        return fruitRepository.findByName(name);
    }
}
