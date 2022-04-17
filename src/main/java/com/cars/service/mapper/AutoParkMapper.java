package com.cars.service.mapper;

import com.cars.dto.AutoParkCreateDto;
import com.cars.dto.AutoParkDto;
import com.cars.entity.AutoPark;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AutoParkMapper {

    private final CarMapper carMapper;

    public AutoParkDto toDto(AutoPark autoPark) {
        AutoParkDto autoParkDto = new AutoParkDto();
        autoParkDto.setId(autoPark.getId());
        autoParkDto.setName(autoPark.getName());
        autoParkDto.setCars(autoPark.getCars()
                .stream()
                .map(carMapper::toDto)
                .collect(Collectors.toList()));
        return autoParkDto;
    }

    public AutoPark toEntity(AutoParkCreateDto autoParkCreateDto) {
        AutoPark autoPark = new AutoPark();
        autoPark.setName(autoParkCreateDto.getName());
        return autoPark;
    }
}
