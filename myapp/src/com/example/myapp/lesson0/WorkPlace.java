package com.example.myapp.lesson0;

import java.util.ArrayList;

/**
 * Created by konstantinaksenov on 15.09.14.
 */
public class WorkPlace {
    public WorkPlace() {
        int integ;

        Cat cat = new Cat();
        cat.setMoustage(6);
        cat.setLegCount(4);
        cat.setName("Cat");
        cat.setStaticInt(1);

        Dog dog = new Dog();
        dog.setClutch(20);
        dog.setLegCount(4);
        dog.setName("Dog");
        dog.isHasASimbol("ASD");
        dog.setStaticInt(2);

        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(dog);
        animals.add(cat);

        Dog.isHasASimbol("Asad");

    }
}
