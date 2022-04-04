package com.cars.exception;

public class CarIdNotFoundException extends ServiceException {

    private static final long serialVersionUID = 2485753960154855022L;

    public CarIdNotFoundException(Long id) {
        super("Car with id: " + id + " not found.");
    }
}
