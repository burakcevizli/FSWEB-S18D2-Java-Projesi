package com.example.workintech.FruitsVegetables.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class FruitErrorResponse {
    private int status;
    private String message;
    private LocalDateTime dateTime;
}
