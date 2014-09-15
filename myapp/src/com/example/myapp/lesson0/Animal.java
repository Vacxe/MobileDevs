package com.example.myapp.lesson0;

abstract public class Animal implements AnimalInterface{
    private int legCount;
    private String name;
    static int staticInt;

    boolean eat, walk, sleep;
    public Animal() {
    }

    public Animal(int legCount) {
        this.legCount = legCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLegCount() {
        return legCount;
    }

    public void setLegCount(int legCount) {
        this.legCount = legCount;
    }

    public static int getStaticInt() {
        return staticInt;
    }

    public static void setStaticInt(int staticInt) {
        Animal.staticInt = staticInt;
    }
}
