package com.example.workintech.FruitsVegetables.controller;



import com.example.workintech.FruitsVegetables.entity.Vegetable;
import com.example.workintech.FruitsVegetables.services.FruitService;
import com.example.workintech.FruitsVegetables.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/vegetable")
public class VegetableController {
    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping("/")
    public List<Vegetable> findAllByPriceASC(){
        return vegetableService.listByPriceASC();
    }
    @GetMapping("/{id}")
    public Vegetable find(@PathVariable Long id){
        return vegetableService.find(id);
    }
    @GetMapping("/desc")
    public List<Vegetable> findAllByPriceDESC(){
        return vegetableService.listByPriceDESC();
    }
    @PostMapping("/")
    public Vegetable save(@RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }
    @PostMapping("/{name}")
    public List<Vegetable> listVegetableByName(@PathVariable String name){
        return vegetableService.listByName(name);
    }
    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable long id){
        return vegetableService.delete(id);
    }
}
