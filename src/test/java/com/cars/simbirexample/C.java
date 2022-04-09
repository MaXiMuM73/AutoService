package com.cars.simbirexample;

public class C extends B {

    public C() {
        System.out.println("Работает конструктор класса C");
        this.speed = 200;
        move();
    }

    @Override
    public void move() {
        super.move();
        System.out.println("Метод move класса С");
        System.out.println(speed);
    }
}
