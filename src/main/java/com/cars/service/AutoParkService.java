package com.cars.service;

import com.cars.dto.AutoParkCreateDto;
import com.cars.dto.CarDto;

import java.util.List;

public interface AutoParkService {
    AutoParkCreateDto create(AutoParkCreateDto autoParkCreateDto);

    List<CarDto> addCar(Long autoParkId, Long carId);

    void deleteCar(Long autoParkId, Long carId);

    List<AutoParkCreateDto> findAll();
}
