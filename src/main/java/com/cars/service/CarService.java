package com.cars.service;

import com.cars.dto.CarCreateDto;
import com.cars.dto.CarDto;
import com.cars.entity.Car;

import java.util.List;

public interface CarService {

    CarDto create(CarCreateDto carCreateDto);

    CarDto update(CarDto carDto);

    CarDto delete(Long id);

    Car findById(Long id);

    List<CarDto> findAll();

    List<CarDto> findAllByModel(String model);

    void testMethod();

    List<CarDto> testMethodWithDto();

    List<CarDto> refreshCache();
}
