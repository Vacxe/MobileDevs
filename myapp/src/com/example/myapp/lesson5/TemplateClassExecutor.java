package com.example.myapp.lesson5;

import com.example.myapp.lesson4.Foo;

import java.util.ArrayList;

/**
 * Created by konstantinaksenov on 13.10.14.
 */
public class TemplateClassExecutor {
    public TemplateClassExecutor() {
        ArrayList<Foo> fooArrayList = new ArrayList<>();
        //TemplateClass<Foo> templateClassArray = new TemplateClass<>();
        Foo foo = new Foo(1,1);
      //  templateClassArray.setArray(new Foo[foo]);
    }
}
