package org.my.homeworks.HW36.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    private int id;
    private String name;
    private double cost;
}
