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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @PostMapping(Urls.AutoPark.Id.Car.FULL)
    public ResponseEntity<CarDto> createCar(@PathVariable Long autoParkId,
                                            @RequestBody CarCreateDto carCreateDto) {
        return ResponseEntity.ok(carService.create(autoParkId, carCreateDto));
    }

    @Operation(summary = "Найти все автомобили")
    @GetMapping(Urls.AutoPark.Id.Car.FULL)
    public ResponseEntity<List<CarDto>> findAll() {
        return ResponseEntity.ok(carService.findAll());
    }

    @Operation(summary = "Удалить автомобиль")
    @DeleteMapping(Urls.AutoPark.Id.Car.CarId.FULL)
    public ResponseEntity<String> delete(@PathVariable Long autoParkId,
                                         @PathVariable Long carId) {
        carService.delete(carId);
        return ResponseEntity.ok("Ok.");
    }

    @GetMapping
    public ResponseEntity<CarDto> find() {
        return null;
    }
}
