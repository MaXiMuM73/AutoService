package com.simbirsoft.cars.service;

import com.simbirsoft.cars.dto.CarCreateDto;
import com.simbirsoft.cars.dto.CarDto;

import java.util.List;

public interface CarService {

    CarDto create(Long autoParkId, CarCreateDto carCreateDto);

    List<CarDto> findAll();

    void delete(Long id);
}
