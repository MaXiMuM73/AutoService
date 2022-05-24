package com.cars.generics;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Box <T>{
    private List<T> box;
}
