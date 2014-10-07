package com.example.myapp.lesson4;

/**
 * Created by konstantinaksenov on 06.10.14.
 */
public class Foo {
    public int a, b;

    public Foo(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) // проверка на обьект
            return false;
        if (this == o)// проверка на соответсвие в памяти
            return true;
        if (!(o instanceof Foo)) // Проверка на класс обьекта для возможности дальнейшего каста во избежание эксепшена
            return false;
        if (this.a != ((Foo) o).a) // проверка переменных на соответсвие
            return false;
        if (this.b != ((Foo) o).b)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * a + b;
        result = result * b + a;
        return result;
    }
}
