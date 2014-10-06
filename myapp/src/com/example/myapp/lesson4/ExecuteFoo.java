package com.example.myapp.lesson4;

import android.graphics.Color;

import java.util.HashMap;

/**
 * Created by konstantinaksenov on 06.10.14.
 */
public class ExecuteFoo {
    public ExecuteFoo() {
        Foo f1 = new Foo(1,15); // Обьекты одинаковые - но в памяти лежат в разных местах - поэтому обычный эквалс не сработает
        Foo f2 = new Foo(1,15);
        Foo f4 = f1; // Обьекты являются одинаковыми в памяти - обычый эквалс сработает
        Foo f3 = new Foo(0,17);

        f1.equals(f2);
        f4.equals(f1);

        HashMap<Foo, String> hashMap = new HashMap<>();

        hashMap.put(f1, "f1");
        hashMap.put(f2, "f2");

        hashMap.get(f1);
    }
}
