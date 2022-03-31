package com.simbirsoft.cars.repository;

import com.simbirsoft.cars.entity.AutoPark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoParkRepository extends JpaRepository<AutoPark, Long> {
}
