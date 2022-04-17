package com.cars.service;

import com.cars.dto.AutoParkCreateDto;
import com.cars.dto.AutoParkDto;
import com.cars.dto.AutoParkUpdateDto;
import com.cars.dto.CarDto;

import java.util.List;

public interface AutoParkService {
    AutoParkDto create(AutoParkCreateDto autoParkCreateDto);

    AutoParkDto update(AutoParkUpdateDto autoParkUpdateDto);

    AutoParkDto delete(Long id);

    List<CarDto> addCar(Long autoParkId, Long carId);

    void deleteCar(Long autoParkId, Long carId);

    List<AutoParkDto> findAll();
}
