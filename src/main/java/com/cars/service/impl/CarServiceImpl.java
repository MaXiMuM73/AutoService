package com.cars.service.impl;

import com.cars.dto.CarCreateDto;
import com.cars.dto.CarDto;
import com.cars.repository.CarRepository;
import com.cars.service.mapper.CarMapper;
import com.cars.entity.Car;
import com.cars.exception.CarIdNotFoundException;
import com.cars.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Transactional
    @Override
    public CarDto create(CarCreateDto carCreateDto) {
        Car car = carMapper.toEntity(carCreateDto);

        car = carRepository.save(car);

        log.info("Car created {}", car);

        return carMapper.toDto(car);
    }

    @Transactional
    @Override
    public CarDto update(CarDto carDto) {
        Car car = findById(carDto.getId());

        car.setManufacturer(carDto.getManufacturer());
        car.setModel(carDto.getModel());

        log.info("Car updated {}", car);

        return carMapper.toDto(carRepository.save(car));
    }

    @Transactional
    @Override
    public CarDto delete(Long id) {
        Car car = findById(id);

        carRepository.delete(car);

        log.info("Car deleted {}", car);

        return carMapper.toDto(car);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CarDto> findAll() {
        return carRepository.findAll()
                .stream()
                .map((carMapper::toDto))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<CarDto> findAllByModel(String model) {
        return carRepository
                .findAllByModel(model)
                .stream()
                .map(carMapper::toDto)
                .collect(Collectors.toList());
    }

    private Car findById(Long id) {
        return carRepository
                .findById(id)
                .orElseThrow(() -> new CarIdNotFoundException(id));
    }
}
