package ru.kpfu.itis.j903.cw.minsafin.inf_5.mynavigableset;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MyNavSetIterator<T> implements Iterator<T> {
    private T[] data = (T[]) new Object[0];
    private int cursor;
    private List<T> list;

    public MyNavSetIterator(List<T> list) {
        this.data = list.toArray(data);
        cursor = 0;
    }

    @Override
    public void remove() {
        if (hasNext()){
            list.remove(data[cursor++]);
        }
    }

    @Override
    public boolean hasNext() {
        return data.length > cursor;
    }

    @Override
    public T next() {
        if (hasNext()){
            return data[cursor++];
        }
        throw new NoSuchElementException();
    }
}
