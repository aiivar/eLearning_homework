package ru.kpfu.itis.j903.cw.minsafin;

import ru.kpfu.itis.j903.cw.minsafin.inf_5.mynavigableset.IntComparator;
import ru.kpfu.itis.j903.cw.minsafin.inf_5.mynavigableset.MyNavigableSet;
import ru.kpfu.itis.j903.cw.minsafin.inf_8.InputOutputTest;

public class Main {

    public static void main(String[] args) {
        IOTest();
    }

    public static void myNavSetTest() {
        MyNavigableSet<Integer> set = new MyNavigableSet<>(new IntComparator());
        set.add(3);
        set.add(2);
        set.add(5);
        set.add(1);
        System.out.println(set);
        System.out.println(set.headSet(5));
        System.out.println(set.descendingSet());
        set.remove(1);
        set.remove(5);
        System.out.println(set);
    }

    public static void IOTest(){
        InputOutputTest inputOutputTest = new InputOutputTest();
        inputOutputTest.execute();
    }
}
