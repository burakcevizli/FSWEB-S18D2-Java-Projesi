package com.example.workintech.FruitsVegetables.controller;

import com.example.workintech.FruitsVegetables.entity.Fruit;
import com.example.workintech.FruitsVegetables.services.FruitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workintech/fruits")
public class FruitController {
    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/")
    public List<Fruit> findAllByPriceASC(){
        return fruitService.listByPriceASC();
    }
    @GetMapping("/{id}")
    public Fruit find(@PathVariable Long id){
        return fruitService.find(id);
    }
    @GetMapping("/desc")
    public List<Fruit> findAllByPriceDESC(){
        return fruitService.listByPriceDESC();
    }
    @PostMapping("/")
    public Fruit save(@RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }
    @PostMapping("/{name}")
    public List<Fruit> listFruitByName(@PathVariable String name){
        return fruitService.listByName(name);
    }
    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable long id){
        return fruitService.delete(id);
    }

}
