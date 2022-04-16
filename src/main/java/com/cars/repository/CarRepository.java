package com.cars.repository;

import com.cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByModel(String model);

    List<Car> findAllByModel(String model);

    List<Car> findAllByIdIn(List<Long> ids);
}
