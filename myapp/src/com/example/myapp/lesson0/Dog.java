package com.example.myapp.lesson0;

/**
 * Created by konstantinaksenov on 15.09.14.
 */
public class Dog extends Animal {
    int clutch;

    public int getClutch() {
        return clutch;
    }

    public void setClutch(int clutch) {
        this.clutch = clutch;
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

    public static boolean isHasASimbol(String string){
        return string.contains("A");
    }
}
