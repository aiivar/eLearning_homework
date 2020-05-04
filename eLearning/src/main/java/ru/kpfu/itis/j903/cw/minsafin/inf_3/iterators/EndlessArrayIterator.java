package ru.kpfu.itis.j903.cw.minsafin.inf_3.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EndlessArrayIterator<T> implements Iterator<T> {
    private T[] data;
    private int size;
    private int cursor;

    public EndlessArrayIterator(Object[] data, int size) {
        this.data = (T[]) data;
        cursor = 0;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return size > cursor;
    }

    @Override
    public T next() {
        try {
            T el = data[cursor];
            cursor++;
            return el;
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new NoSuchElementException();
        }
    }
}
