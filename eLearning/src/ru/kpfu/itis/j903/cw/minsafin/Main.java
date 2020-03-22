package ru.kpfu.itis.j903.cw.minsafin;

import ru.kpfu.itis.j903.cw.minsafin.inf_5.mynavigableset.IntComparator;
import ru.kpfu.itis.j903.cw.minsafin.inf_5.mynavigableset.MyNavigableSet;
import ru.kpfu.itis.j903.cw.minsafin.inf_6.MyMap;
import ru.kpfu.itis.j903.cw.minsafin.inf_6.setformap.FromArrayListSet;
import ru.kpfu.itis.j903.cw.minsafin.inf_7.StreamApiHomework;
import ru.kpfu.itis.j903.cw.minsafin.inf_8.InputOutputTest;
import ru.kpfu.itis.j903.cw.minsafin.inf_9.StudentByteBufferReaderWriter;
import ru.kpfu.itis.j903.cw.minsafin.inf_9.student.BirthDate;
import ru.kpfu.itis.j903.cw.minsafin.inf_9.student.Student;

import java.io.File;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        byteBufferTest();
    }

    public static void byteBufferTest() {
        Student s1 = new Student(new BirthDate(12, 12, 1999), "Aivar Minsafin",11903);
        Student s2 = new Student(new BirthDate(10, 5, 1923), "Nikita Nikitich",11903);
        Student s3 = new Student(new BirthDate(21, 4, 3000), "Nikita ???????",11903);
        List<Student> students= new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        StudentByteBufferReaderWriter.write(students);
        Collection<Student> students1 = StudentByteBufferReaderWriter.read(new File(StudentByteBufferReaderWriter.path));
        System.out.println(students1);
    }

    public static void streamApiTest() {
        StreamApiHomework.execute();
    }

    public static void myMapTest() {
        Set<Map.Entry<Integer, String>> set = new FromArrayListSet<>();
        AbstractMap.SimpleEntry<Integer, String> entry = new AbstractMap.SimpleEntry<>(2, "Hello");
        set.add(entry);
        MyMap<Integer, String> myMap = new MyMap<>(set);
        System.out.println(myMap.values());
        MyMap<Integer, String> myMap2 = new MyMap<>();
        myMap2.put(2, "Hi");
        myMap2.put(3, "Test");
        myMap2.put(3, "Deleted");
        System.out.println(myMap2.values());
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

    public static void IOTest() {
        InputOutputTest inputOutputTest = new InputOutputTest();
        inputOutputTest.execute();
    }
}
