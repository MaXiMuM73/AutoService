package com.cars.exception;

public class CarIdNotFoundException extends ServiceException {
    public CarIdNotFoundException(Long id) {
        super("Car with id: " + id + " not found.");
    }
}
