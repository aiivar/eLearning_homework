package ru.kpfu.itis.j903.cw.minsafin.inf_9.student;

import java.util.Objects;

public class Student {
    private BirthDate birthDate;
    private String name;
    private int group;

    public Student(BirthDate birthDate, String name, int group) {
        this.birthDate = birthDate;
        this.name = name;
        this.group = group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public BirthDate getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }

    public int getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return group == student.group &&
                Objects.equals(birthDate, student.birthDate) &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthDate, name, group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "birthDate=" + birthDate +
                ", name='" + name + '\'' +
                ", group=" + group +
                '}';
    }
}
