package com.Lottery;

import java.lang.reflect.InvocationTargetException;

public class AnnoTest {

    public static void main(String args[]) throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {
        Animal animal = AnimalFactory.getAnimal(Dog.class);
        System.out.println(animal.getName());
        System.out.println(animal.getLName());
    }

}
