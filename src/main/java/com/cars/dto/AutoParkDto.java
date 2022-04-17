package com.cars.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AutoParkDto {
    private Long id;
    private String name;
    private List<CarDto> cars;
}
