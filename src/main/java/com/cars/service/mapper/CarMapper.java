package com.cars.service.mapper;

import com.cars.dto.CarCreateDto;
import com.cars.dto.CarDto;
import com.cars.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarDto toDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setManufacturer(car.getManufacturer());
        carDto.setModel(car.getModel());
        return carDto;
    }

    public Car toEntity(CarCreateDto carDto) {
        Car car = new Car();
        car.setManufacturer(carDto.getManufacturer());
        car.setModel(carDto.getModel());
        return car;
    }
}
