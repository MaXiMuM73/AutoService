package com.cars.otherClassPackage;

import com.cars.interfaceTest.ParentClass;

public class SomeClass extends ParentClass {
    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        someClass.parentMethod();
    }
}
