package ru.kpfu.itis.j903.cw.minsafin.inf_9.student;

import java.util.Objects;

public class BirthDate {
    private byte day;
    private byte month;
    private short year;

    public BirthDate(int day, int month, int year) {
        this.day = (byte) day;
        this.month = (byte) month;
        this.year = (short) year;
    }


    public byte getDay() {
        return day;
    }

    public byte getMonth() {
        return month;
    }

    public short getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "BirthDate{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirthDate birthDate = (BirthDate) o;
        return day == birthDate.day &&
                month == birthDate.month &&
                year == birthDate.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }
}
