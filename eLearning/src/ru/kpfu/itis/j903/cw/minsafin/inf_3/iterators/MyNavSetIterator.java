package ru.kpfu.itis.j903.cw.minsafin.inf_3.iterators;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MyNavSetIterator<T> implements Iterator<T> {
    private List<T> list;
    private int cursor;

    public MyNavSetIterator(List<T> list) {
        this.list = list;
        cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return list.size() > cursor;
    }

    @Override
    public T next() {
        if (hasNext()){
            return list.get(cursor++);
        }
        throw new NoSuchElementException();
    }
}
