package com.cars.service.impl;

import com.cars.dto.AutoParkDto;
import com.cars.dto.CarCreateDto;
import com.cars.dto.CarDto;
import com.cars.entity.BlobEntity;
import com.cars.entity.Car;
import com.cars.exception.CarIdNotFoundException;
import com.cars.repository.BlobRepository;
import com.cars.repository.CarRepository;
import com.cars.service.AutoParkService;
import com.cars.service.CarService;
import com.cars.service.mapper.CarMapper;
import java.util.UUID;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final BlobRepository blobRepository;
    private final CarMapper carMapper;

    @Lazy
    @Autowired
    private AutoParkService autoParkService;

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

    @Transactional
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

    @Cacheable("cars")
    @Override
    public void testMethod() {
        log.info("Test method");
        List<Car> all = carRepository.findAll();
        carRepository.saveAll(all);
    }

    @Cacheable("cars2")
    @Override
    public List<CarDto> testMethodWithDto() {
        log.info("Test method with dto");
        List<Car> all = carRepository.findAll();
        refreshCache();
        return all
                .stream()
                .map(carMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @CachePut(value = "cars2")
    public List<CarDto> refreshCache() {
        log.info("Test method with dto");
        List<Car> all = carRepository.findAll();
        return all
                .stream()
                .map(carMapper::toDto)
                .collect(Collectors.toList());
    }

    public Car findById(Long id) {
        return carRepository
                .findById(id)
                .orElseThrow(() -> new CarIdNotFoundException(id));
    }

    public void testBlob() {
        Optional<BlobEntity> blob = blobRepository.findById(1L);
        if (blob.isPresent()) {
            BlobEntity blobEntity = blob.get();
        }
    }

    @Override
    public void callFuncFromDb() {
        List<ResultSet> resultSet = carRepository.callFuncFromDb();
    }

    @Transactional
    public void testTransaction() {
        Car car = carRepository.findById(2L).get();
        car.setModel(UUID.randomUUID().toString());
        carRepository.save(car);

        List<AutoParkDto> all = autoParkService.findAll();
    }
}
