package com.cars.controller;

import com.cars.config.constants.Urls;
import com.cars.dto.AutoParkCreateDto;
import com.cars.dto.AutoParkDto;
import com.cars.dto.AutoParkUpdateDto;
import com.cars.dto.CarDto;
import com.cars.service.AutoParkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @Operation(summary = "Добавить автопарк")
    @PostMapping(Urls.AutoPark.FULL)
    public ResponseEntity<AutoParkDto> createAutoPark(@RequestBody AutoParkCreateDto autoParkCreateDto) {
        return ResponseEntity.ok(autoParkService.create(autoParkCreateDto));
    }

    @Operation(summary = "Обновить автопарк")
    @PutMapping(Urls.AutoPark.FULL)
    public ResponseEntity<AutoParkDto> update(@RequestBody AutoParkUpdateDto autoParkUpdateDto) {
        return ResponseEntity.ok(autoParkService.update(autoParkUpdateDto));
    }

    @Operation(summary = "Удалить автопарк")
    @DeleteMapping(Urls.AutoPark.Id.FULL)
    public ResponseEntity<AutoParkDto> delete(@PathVariable Long autoParkId) {
        return ResponseEntity.ok(autoParkService.delete(autoParkId));
    }

    @Operation(summary = "Найти все автопарки")
    @GetMapping(value = Urls.AutoPark.FULL)
    public ResponseEntity<List<AutoParkDto>> findAll() {
        return ResponseEntity.ok(autoParkService.findAll());
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
