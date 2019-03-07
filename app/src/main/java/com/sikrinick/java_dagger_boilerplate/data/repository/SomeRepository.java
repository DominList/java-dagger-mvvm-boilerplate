package com.sikrinick.java_dagger_boilerplate.data.repository;

import java.util.Random;

import javax.inject.Inject;

public class SomeRepository {

    private int counter;

    @Inject
    public SomeRepository() {
        counter = 0;
    }

    public String getHelloWorld() {
        boolean success = new Random().nextBoolean();
        if (success) {
            return "Hello, World: " + ++counter;
        } else {
            throw new RuntimeException("Wow, error!");
        }
    }

}
