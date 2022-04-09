package com.cars.simbirexample;

public class B extends A{

    public B() {
        this.speed = 10;
        System.out.println("Работает конструктор В");
        System.out.println("Вызываю метод move класса А из конструктора В");
        super.move();
    }

    @Override
    public void move() {

        System.out.println("Метод move класса В");
        this.speed++;
        System.out.println(speed);
    }
}
