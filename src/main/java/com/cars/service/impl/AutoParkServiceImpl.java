package com.cars.service.impl;

import com.cars.dto.AutoParkCreateDto;
import com.cars.dto.CarDto;
import com.cars.entity.AutoPark;
import com.cars.entity.Car;
import com.cars.exception.AutoParkIdNotFoundException;
import com.cars.repository.AutoParkRepository;
import com.cars.repository.CarRepository;
import com.cars.service.AutoParkService;
import com.cars.service.mapper.AutoParkMapper;
import com.cars.service.mapper.CarMapper;
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
        AutoPark autoPark = findById(autoParkId);
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

    private AutoPark findById(Long id) {
        return autoParkRepository.findById(id)
                .orElseThrow(() -> new AutoParkIdNotFoundException(id));
    }
}
