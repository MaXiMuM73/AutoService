package com.simbirsoft.cars.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {

    @Id
    @SequenceGenerator(name = "carIdSeq", sequenceName = "car_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carIdSeq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "manufacturer", columnDefinition = "varchar(500)", nullable = false)
    private String manufacturer;

    @Column(name = "model", columnDefinition = "varchar(500)", nullable = false)
    private String model;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private AutoPark autoPark;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Driver driver;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!id.equals(car.id)) return false;
        if (!manufacturer.equals(car.manufacturer)) return false;
        return model.equals(car.model);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + manufacturer.hashCode();
        result = 31 * result + model.hashCode();
        return result;
    }
}
