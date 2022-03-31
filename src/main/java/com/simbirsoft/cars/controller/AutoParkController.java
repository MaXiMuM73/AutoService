package com.simbirsoft.cars.controller;

import com.simbirsoft.cars.config.constants.Urls;
import com.simbirsoft.cars.dto.AutoParkCreateDto;
import com.simbirsoft.cars.dto.CarDto;
import com.simbirsoft.cars.service.AutoParkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Autopark controller", description = "Autopark management / Управление автопарками")
@RestController
public class AutoParkController {

    private final AutoParkService autoParkService;

    public AutoParkController(AutoParkService autoParkService) {
        this.autoParkService = autoParkService;
    }

    @Operation(summary = "Найти все автопарки")
    @GetMapping(value = Urls.AutoPark.FULL)
    public ResponseEntity<List<AutoParkCreateDto>> findAll() {
        return ResponseEntity.ok(autoParkService.findAll());
    }

    @Operation(summary = "Добавить автомобиль в автопарк")
    @PostMapping(Urls.AutoPark.FULL)
    public ResponseEntity<AutoParkCreateDto> createAutoPark(@RequestBody AutoParkCreateDto autoParkCreateDto) {
        return ResponseEntity.ok(autoParkService.create(autoParkCreateDto));
    }

    @PostMapping(Urls.AutoPark.Id.Car.CarId.FULL)
    public ResponseEntity<List<CarDto>> addCar(@PathVariable Long autoParkId,
                                               @PathVariable Long carId) {
        return ResponseEntity.ok(autoParkService.addCar(autoParkId, carId));
    }

    @DeleteMapping(Urls.AutoPark.Id.Car.CarId.FULL + "/test")
    public ResponseEntity<String> deleteCar(@PathVariable Long autoParkId,
                                            @PathVariable Long carId) {
        autoParkService.deleteCar(autoParkId, carId);
        return ResponseEntity.ok("Ok");
    }
}
