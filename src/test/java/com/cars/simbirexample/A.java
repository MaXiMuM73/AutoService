package com.cars.simbirexample;

public class A {
    protected int speed;

    public A() {
        this.speed = 25;
        System.out.println("Работает конструктор А");
        move();
    }

    public void move() {
        System.out.println("Метод move класса А");
        System.out.println(speed);
        privateMethod();
    }

    private void privateMethod() {
        System.out.println("Вызов private метода класса А");
        System.out.println(speed);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
