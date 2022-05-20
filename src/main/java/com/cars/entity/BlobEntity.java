package com.cars.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_blob")
@Getter
@Setter
public class BlobEntity {
    @Id
    private Long id;

    private byte[] blob;
}
