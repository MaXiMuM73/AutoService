package com.cars.service.mapper;

import com.cars.dto.AutoParkCreateDto;
import com.cars.entity.AutoPark;
import org.springframework.stereotype.Component;

@Component
public class AutoParkMapper {

    public AutoParkCreateDto toDto(AutoPark autoPark) {
        AutoParkCreateDto autoParkCreateDto = new AutoParkCreateDto();
        autoParkCreateDto.setId(autoPark.getId());
        autoParkCreateDto.setName(autoPark.getName());
        return autoParkCreateDto;
    }

    public AutoPark toEntity(AutoParkCreateDto autoParkCreateDto) {
        AutoPark autoPark = new AutoPark();
        autoPark.setName(autoParkCreateDto.getName());
        return autoPark;
    }
}
