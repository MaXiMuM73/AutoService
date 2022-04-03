package com.simbirsoft.cars.controller;

import com.simbirsoft.cars.config.constants.Urls;
import com.simbirsoft.cars.dto.CarCreateDto;
import com.simbirsoft.cars.dto.CarDto;
import com.simbirsoft.cars.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Car controller", description = "Car management / Управление автомобилями")
@RestController
@RequestMapping()
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Operation(summary = "Добавить автомобиль")
    @PostMapping(Urls.Car.FULL)
    public ResponseEntity<CarDto> createCar(@RequestBody CarCreateDto carCreateDto) {
        return ResponseEntity.ok(carService.create(carCreateDto));
    }

    @Operation(summary = "Изменить характеристики автомобиля")
    @PutMapping(Urls.Car.FULL)
    public ResponseEntity<CarDto> updateCar(@RequestBody CarDto carDto) {
        return ResponseEntity.ok(carService.update(carDto));
    }

    @Operation(summary = "Удалить автомобиль")
    @DeleteMapping(Urls.Car.FULL)
    public ResponseEntity<CarDto> delete(@RequestParam Long id) {
        return ResponseEntity.ok(carService.delete(id));
    }

    @Operation(summary = "Найти все автомобили")
    @GetMapping(Urls.Car.FULL)
    public ResponseEntity<List<CarDto>> findAll() {
        return ResponseEntity.ok(carService.findAll());
    }

    @Operation(summary = "Найти все автомобили по модели")
    @GetMapping(Urls.Car.Search.FULL)
    public ResponseEntity<List<CarDto>> findAllByModel(@RequestParam String model) {
        return ResponseEntity.ok(carService.findAllByModel(model));
    }
}
