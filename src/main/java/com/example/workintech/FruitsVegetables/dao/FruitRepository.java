package com.example.workintech.FruitsVegetables.dao;

import com.example.workintech.FruitsVegetables.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit , Long> {

    @Query("SELECT f FROM Fruit v ORDER BY f.price DESC")
    List<Fruit> listByPriceDESC();
    @Query("SELECT f FROM Vegetable f ORDER BY f.price ASC")
    List<Fruit> listByPriceASC();

    @Query("SELECT f FROM Fruit f WHERE f.name ILIKE %:name%")
    List<Fruit> findByName(String name);

}
