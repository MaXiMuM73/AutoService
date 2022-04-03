package com.simbirsoft.cars.exception;

public class CarIdNotFoundException extends AppException{
    public CarIdNotFoundException(Long id) {
        super("Car with id: " + id + " not found.");
    }
}
