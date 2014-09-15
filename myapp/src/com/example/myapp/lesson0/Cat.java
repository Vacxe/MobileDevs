package com.example.myapp.lesson0;

/**
 * Created by konstantinaksenov on 15.09.14.
 */
public class Cat extends Animal {
    int moustage;

    public int getMoustage() {
        return moustage;
    }

    public void setMoustage(int moustage) {
        this.moustage = moustage;
    }


    @Override
    public void walk(boolean walk) {
        this.walk = walk;
    }

    @Override
    public void eat(boolean eat) {
        this.eat = eat;
    }

    @Override
    public void sleep(boolean sleep) {
        this.sleep = sleep;
    }
}
