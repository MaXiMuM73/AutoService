package com.cars.repository;

import com.cars.entity.BlobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlobRepository extends JpaRepository<BlobEntity, Long> {

}
