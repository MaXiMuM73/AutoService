package com.cars.service.impl;

import com.cars.dto.CarCreateDto;
import com.cars.dto.CarDto;
import com.cars.entity.Car;
import com.cars.exception.CarIdNotFoundException;
import com.cars.repository.CarRepository;
import com.cars.service.mapper.CarMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CarServiceImplTest {

    @InjectMocks
    private CarServiceImpl carService;
    @Mock
    private CarRepository carRepository;
    @Mock
    private CarMapper carMapper;

    @Test
    public void createPositive() {
        CarCreateDto carCreateDto = new CarCreateDto();
        Car car = Car.builder()
                .manufacturer("Lada")
                .model("Vesta")
                .build();
        CarDto carDto = new CarDto();

        when(carMapper.toEntity(carCreateDto)).thenReturn(car);
        when(carRepository.save(car)).thenReturn(car);
        when(carMapper.toDto(car)).thenReturn(carDto);

        CarDto result = carService.create(carCreateDto);

        assertEquals(carDto, result);

        verify(carMapper).toEntity(carCreateDto);
        verify(carRepository).save(car);
        verify(carMapper).toDto(car);
    }

    @Test
    public void updatePositive() {
        CarDto carDto = new CarDto();
        carDto.setId(1L);
        carDto.setManufacturer("Lada");
        carDto.setModel("Vesta");
        Car car = Car.builder()
                .manufacturer(carDto.getManufacturer())
                .model(carDto.getModel())
                .build();

        when(carRepository.findById(carDto.getId())).thenReturn(Optional.of(car));
        when(carRepository.save(car)).thenReturn(car);
        when(carMapper.toDto(car)).thenReturn(carDto);

        CarDto result = carService.update(carDto);

        assertEquals(carDto, result);

        verify(carRepository).findById(carDto.getId());
        verify(carRepository).save(car);
        verify(carMapper).toDto(car);
    }

    @Test(expected = CarIdNotFoundException.class)
    public void updateNegative() {
        CarDto carDto = new CarDto();
        carDto.setId(1L);

        carService.update(carDto);

        verify(carRepository).findById(carDto.getId());
    }

    @Test
    public void deletePositive() {
        Car car = Car.builder()
                .id(1L)
                .build();
        CarDto carDto = new CarDto();

        when(carRepository.findById(1L)).thenReturn(Optional.of(car));
        when(carMapper.toDto(car)).thenReturn(carDto);

        carService.delete(car.getId());

        verify(carRepository).findById(1L);
        verify(carRepository).delete(car);
        verify(carMapper).toDto(car);
    }

    @Test(expected = CarIdNotFoundException.class)
    public void deleteNegative() {
        carService.delete(1L);

        verify(carRepository).findById(1L);
    }
}
