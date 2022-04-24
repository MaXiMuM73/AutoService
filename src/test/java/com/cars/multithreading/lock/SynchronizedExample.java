package com.cars.multithreading.lock;

public class SynchronizedExample implements Runnable {
    private final Resource resource;

    public SynchronizedExample(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        synchronized (resource) {
            resource.doSomething();
        }
        resource.doLogging();
    }
}
