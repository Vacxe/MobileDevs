package com.example.myapp.lesson5;

/**
 * Created by konstantinaksenov on 13.10.14.
 */
public class TemplateClass<T,E,V,F> {
    T array[];
    E size;

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public int size(){
        return this.array.length;
    }

    public T getItem(int position){
        return array[position];
    }
}
