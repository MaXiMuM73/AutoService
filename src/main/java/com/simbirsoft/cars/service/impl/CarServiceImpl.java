package com.simbirsoft.cars.service.impl;

import com.simbirsoft.cars.dto.CarCreateDto;
import com.simbirsoft.cars.dto.CarDto;
import com.simbirsoft.cars.entity.Car;
import com.simbirsoft.cars.exception.CarIdNotFoundException;
import com.simbirsoft.cars.repository.AutoParkRepository;
import com.simbirsoft.cars.repository.CarRepository;
import com.simbirsoft.cars.service.CarService;
import com.simbirsoft.cars.service.mapper.CarMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
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
        return carMapper.toDto(carRepository.save(car));
    }

    @Transactional
    @Override
    public CarDto delete(Long id) {
        Car car = findById(id);
        carRepository.delete(car);
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
