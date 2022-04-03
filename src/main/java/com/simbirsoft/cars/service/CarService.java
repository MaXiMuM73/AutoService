package com.simbirsoft.cars.service;

import com.simbirsoft.cars.dto.CarCreateDto;
import com.simbirsoft.cars.dto.CarDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarService {

    CarDto create(CarCreateDto carCreateDto);

    CarDto update(CarDto carDto);

    CarDto delete(Long id);

    List<CarDto> findAll();

    List<CarDto> findAllByModel(String model);
}
