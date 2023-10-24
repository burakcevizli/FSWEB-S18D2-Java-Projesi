package com.example.workintech.FruitsVegetables.services;

import com.example.workintech.FruitsVegetables.dao.VegetableRepository;
import com.example.workintech.FruitsVegetables.entity.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{

    private VegetableRepository vegetableRepository;
    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable find(long id) {
        Optional<Vegetable> vegetableOptional = vegetableRepository.findById(id);
        if(vegetableOptional.isPresent()){
            return vegetableOptional.get();
        }
        return null;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(long id) {
        Vegetable vegetable = find(id);
        vegetableRepository.delete(vegetable);
        return vegetable;
    }

    @Override
    public List<Vegetable> listByPriceDESC() {
        return vegetableRepository.listByPriceDESC();
    }

    @Override
    public List<Vegetable> listByPriceASC() {
        return vegetableRepository.listByPriceASC();
    }


    @Override
    public List<Vegetable> listByName(String name) {
        return vegetableRepository.findByName(name);
    }
}
