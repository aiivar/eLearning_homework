package ru.kpfu.itis.j903.cw.minsafin;

import ru.kpfu.itis.j903.cw.minsafin.inf_5.mynavigableset.IntComparator;
import ru.kpfu.itis.j903.cw.minsafin.inf_5.mynavigableset.MyNavigableSet;

public class Main {

    public static void main(String[] args) {
        myNavSetTest();
    }

    public static void myNavSetTest(){
        MyNavigableSet<Integer> set= new MyNavigableSet<>(new IntComparator());
        set.add(3);
        set.add(2);
        set.add(5);
        set.add(1);
        System.out.println(set);
        System.out.println(set.headSet(5));
        System.out.println(set.descendingSet());
    }
}
