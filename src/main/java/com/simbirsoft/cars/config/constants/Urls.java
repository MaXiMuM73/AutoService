package com.simbirsoft.cars.config.constants;

public interface Urls {
    String ROOT = "/api";

    interface AutoPark {
        String NAME = "autopark";
        String FULL = ROOT + "/" + NAME;

        interface Id {
            String NAME = "{autoParkId}";
            String FULL = AutoPark.FULL + "/" + NAME;

            interface Car {
                String NAME = "car";
                String FULL = Id.FULL + "/" + NAME;

                interface CarId {
                    String NAME = "{carId}";
                    String FULL = Car.FULL + "/" + NAME;
                }
            }
        }
    }
}