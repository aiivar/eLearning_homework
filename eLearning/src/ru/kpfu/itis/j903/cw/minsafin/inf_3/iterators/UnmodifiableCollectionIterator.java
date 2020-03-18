package ru.kpfu.itis.j903.cw.minsafin.inf_3.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnmodifiableCollectionIterator<T> implements Iterator<T> {
    protected T[] data;
    protected int cursor;

    public UnmodifiableCollectionIterator(Object[] data) {
        this.data = (T[]) data;
        cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return data.length > cursor;
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
