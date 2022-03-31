package com.simbirsoft.cars.service.impl;

import com.simbirsoft.cars.dto.AutoParkCreateDto;
import com.simbirsoft.cars.dto.CarDto;
import com.simbirsoft.cars.entity.AutoPark;
import com.simbirsoft.cars.entity.Car;
import com.simbirsoft.cars.repository.AutoParkRepository;
import com.simbirsoft.cars.repository.CarRepository;
import com.simbirsoft.cars.service.AutoParkService;
import com.simbirsoft.cars.service.mapper.AutoParkMapper;
import com.simbirsoft.cars.service.mapper.CarMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AutoParkServiceImpl implements AutoParkService {

    private final AutoParkRepository autoParkRepository;
    private final AutoParkMapper autoParkMapper;
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public AutoParkServiceImpl(AutoParkRepository autoParkRepository,
                               AutoParkMapper autoParkMapper, CarRepository carRepository,
                               CarMapper carMapper) {
        this.autoParkRepository = autoParkRepository;
        this.autoParkMapper = autoParkMapper;
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public List<AutoParkCreateDto> findAll() {
        return autoParkRepository.findAll()
                .stream()
                .map(autoParkMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AutoParkCreateDto create(AutoParkCreateDto autoParkCreateDto) {
        AutoPark autoPark = autoParkRepository.save(autoParkMapper.toEntity(autoParkCreateDto));
        return autoParkMapper.toDto(autoPark);
    }

    @Override
    public List<CarDto> addCar(Long autoParkId, Long carId) {
        AutoPark autoPark = autoParkRepository.findById(autoParkId).get();
        Car car = carRepository.findById(carId).get();
        car.setAutoPark(autoPark);
        Set<Car> cars = autoPark.getCars();
        cars.add(car);
        autoParkRepository.save(autoPark);
        return autoPark.getCars().stream().map(carMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCar(Long autoParkId, Long carId) {
        AutoPark autoPark = autoParkRepository.findById(autoParkId).get();
        Car car = carRepository.findById(carId).get();
        Set<Car> cars = autoPark.getCars();
        cars.remove(car);
        autoParkRepository.save(autoPark);
    }
}
