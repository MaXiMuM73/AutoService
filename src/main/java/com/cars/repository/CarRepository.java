package com.cars.repository;

import com.cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByModel(String model);

    List<Car> findAllByModel(String model);

    List<Car> findAllByIdIn(List<Long> ids);

//    @Procedure("select_car")
    @Query(value = "select * from select_car()", nativeQuery = true)
    List<ResultSet> callFuncFromDb();
}
