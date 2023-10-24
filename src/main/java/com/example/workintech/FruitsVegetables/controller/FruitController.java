package com.example.workintech.FruitsVegetables.controller;

import com.example.workintech.FruitsVegetables.entity.Fruit;
import com.example.workintech.FruitsVegetables.services.FruitService;
import java.util.List;

import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.Size;

@Validated
@RestController
@RequestMapping("/workintech/fruits")
public class FruitController {
    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/")
    public List<Fruit> findByPriceASC(){
        return fruitService.listByPriceASC();
    }
    @GetMapping("/{id}")
    public Fruit find(@Positive @PathVariable Long id){
        return fruitService.find(id);
    }
    @GetMapping("/desc")
    public List<Fruit> findByPriceDESC(){
        return fruitService.listByPriceDESC();
    }
    @PostMapping("/")
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }
    @PostMapping("/{name}")
    public List<Fruit> listFruitByName(@Size(min = 2,max = 45)@PathVariable String name){
        return fruitService.listByName(name);
    }
    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable long id){
        return fruitService.delete(id);
    }

}
