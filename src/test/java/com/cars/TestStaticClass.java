package com.cars;

public class TestStaticClass {

    public static void main(String[] args) {
        InnerClassStatic innerClassStatic = new InnerClassStatic();
    }

    public void test() {
        InnerClassNotStatic innerClassNotStatic = new InnerClassNotStatic();
        TestStaticClass testStaticClass = new TestStaticClass();
        InnerClassNotStatic innerClassNotStatic1 = testStaticClass.new InnerClassNotStatic();
        InnerClassNotStatic innerClassNotStatic2 = testStaticClass.new InnerClassNotStatic();
    }

    static public class InnerClassStatic {
    }

    public class InnerClassNotStatic {
    }
}