package ru.kpfu.itis.j903.cw.minsafin.inf_1;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                Double.compare(human.height, height) == 0 &&
                Double.compare(human.weight, weight) == 0 &&
                Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, height, weight);
    }
}
