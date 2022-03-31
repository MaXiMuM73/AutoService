package com.simbirsoft.cars.service.impl;

import com.simbirsoft.cars.dto.CarCreateDto;
import com.simbirsoft.cars.dto.CarDto;
import com.simbirsoft.cars.entity.AutoPark;
import com.simbirsoft.cars.entity.Car;
import com.simbirsoft.cars.exception.AutoParkIdNotFoundException;
import com.simbirsoft.cars.exception.CarIdNotFoundException;
import com.simbirsoft.cars.repository.AutoParkRepository;
import com.simbirsoft.cars.repository.CarRepository;
import com.simbirsoft.cars.service.CarService;
import com.simbirsoft.cars.service.mapper.CarMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final AutoParkRepository autoParkRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper,
                          AutoParkRepository autoParkRepository) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
        this.autoParkRepository = autoParkRepository;
    }

    @Override
    public CarDto create(Long autoParkId, CarCreateDto carCreateDto) {
        AutoPark autoPark = autoParkRepository
                .findById(autoParkId)
                .orElseThrow(() -> new AutoParkIdNotFoundException(autoParkId));

        Car car = carMapper.toEntity(carCreateDto);
        car.setAutoPark(autoPark);

        car = carRepository.save(car);

        log.info("Car created {}", car);

        return carMapper.toDto(car);
    }

    @Override
    public List<CarDto> findAll() {
        return carRepository.findAll()
                .stream()
                .map((carMapper::toDto))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarIdNotFoundException(id));
        carRepository.delete(car);
    }
}
