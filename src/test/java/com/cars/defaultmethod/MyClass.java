package com.cars.defaultmethod;

public class MyClass implements MyInterface {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
        myClass.interfaceMethod();
    }

    private void interfaceMethod() {
        myMethod();
    }

    @Override
    public void myMethod() {
        System.out.println("Additional logic");
    }
}
