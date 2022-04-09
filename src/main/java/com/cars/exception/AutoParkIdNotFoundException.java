package com.cars.exception;

public class AutoParkIdNotFoundException extends ServiceException {
    public AutoParkIdNotFoundException(Long id) {
        super("Autopark with id: " + id + " not found.");
    }
}
