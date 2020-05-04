package ru.kpfu.itis.j903.cw.minsafin.inf_2.numberwithgenerics;

public interface Number<T> extends Comparable<T> {
    T sum(T num);
    T subtract(T num);
    T div(T num);
    T mult(T num);
    T getValue();
}
