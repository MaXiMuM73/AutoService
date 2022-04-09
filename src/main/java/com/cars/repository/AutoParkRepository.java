package com.cars.repository;

import com.cars.entity.AutoPark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoParkRepository extends JpaRepository<AutoPark, Long> {
}
