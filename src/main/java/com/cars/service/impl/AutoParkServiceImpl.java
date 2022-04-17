package com.cars.service.impl;

import com.cars.dto.AutoParkCreateDto;
import com.cars.dto.AutoParkDto;
import com.cars.dto.AutoParkUpdateDto;
import com.cars.dto.CarDto;
import com.cars.entity.AutoPark;
import com.cars.entity.Car;
import com.cars.exception.AutoParkIdNotFoundException;
import com.cars.repository.AutoParkRepository;
import com.cars.service.AutoParkService;
import com.cars.service.CarService;
import com.cars.service.mapper.AutoParkMapper;
import com.cars.service.mapper.CarMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@Service
@AllArgsConstructor
public class AutoParkServiceImpl implements AutoParkService {

    private final AutoParkRepository autoParkRepository;
    private final CarService carService;

    private final AutoParkMapper autoParkMapper;
    private final CarMapper carMapper;

    @Override
    @Transactional
    public AutoParkDto create(AutoParkCreateDto autoParkCreateDto) {
        AutoPark autoPark = autoParkRepository
                .save(autoParkMapper.toEntity(autoParkCreateDto));

        log.info("Autopark created {}", autoPark);

        return autoParkMapper.toDto(autoPark);
    }

    @Override
    @Transactional
    public AutoParkDto update(AutoParkUpdateDto autoParkUpdateDto) {
        AutoPark autopark = findById(autoParkUpdateDto.getId());
        autopark.setName(autoParkUpdateDto.getName());

        return autoParkMapper.toDto(autopark);
    }

    @Override
    @Transactional
    public AutoParkDto delete(Long id) {
        AutoPark autoPark = findById(id);
        autoParkRepository.delete(autoPark);

        log.info("Autopark with id {} deleted", id);

        return autoParkMapper.toDto(autoPark);
    }

    @Override
    @Transactional
    public List<CarDto> addCar(Long autoParkId, Long carId) {
        AutoPark autoPark = findById(autoParkId);
        Car car = carService.findById(carId);
        if (autoPark.getCars().add(car)) {
            car.setAutoPark(autoPark);
        }

        autoParkRepository.save(autoPark);

        return autoPark.getCars().stream().map(carMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<CarDto> deleteCar(Long autoParkId, Long carId) {
        AutoPark autoPark = findById(autoParkId);
        Car car = carService.findById(carId);
        Set<Car> cars = autoPark.getCars();
        if (cars.remove(car)) {
            car.setAutoPark(null);
        }

        autoParkRepository.save(autoPark);

        return cars
                .stream()
                .map(carMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AutoParkDto> findAll() {
        return autoParkRepository.findAll()
                .stream()
                .map(autoParkMapper::toDto)
                .collect(Collectors.toList());
    }

    private AutoPark findById(Long id) {
        return autoParkRepository.findById(id)
                .orElseThrow(() -> new AutoParkIdNotFoundException(id));
    }
}
