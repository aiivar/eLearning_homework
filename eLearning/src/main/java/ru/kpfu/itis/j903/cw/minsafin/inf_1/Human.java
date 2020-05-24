package ru.kpfu.itis.j903.cw.minsafin.inf_1;

public class Human implements Comparable<Human> {
    private String name;
    private int age;
    private double height;
    private double weight;

    public Human(String name, int age, double height, double weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Human o) {
        return age - o.age;
    }
}
