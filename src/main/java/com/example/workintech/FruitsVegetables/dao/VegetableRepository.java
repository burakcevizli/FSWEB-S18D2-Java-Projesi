package com.example.workintech.FruitsVegetables.dao;

import com.example.workintech.FruitsVegetables.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable , Long> {

    @Query("SELECT v FROM Vegetable v ORDER BY v.price DESC")
    List<Vegetable> listByPriceDESC();
    @Query("SELECT v FROM Vegetable v ORDER BY v.price ASC")
    List<Vegetable> listByPriceASC();

    @Query("SELECT v FROM Vegetable v WHERE v.name ILIKE %:name%")
    List<Vegetable> findByName(String name);
}
