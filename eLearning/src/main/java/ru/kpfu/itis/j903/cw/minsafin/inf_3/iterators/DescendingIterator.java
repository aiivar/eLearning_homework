package ru.kpfu.itis.j903.cw.minsafin.inf_3.iterators;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class DescendingIterator<T> implements Iterator<T> {
    private List<T> list;
    private int cursor;

    public DescendingIterator(List<T> list) {
        this.list = list;
        this.cursor = list.size()-1;
    }

    @Override
    public boolean hasNext() {
        return cursor != -1;
    }

    @Override
    public T next() {
        if (hasNext()){
            return list.get(cursor--);
        }
        throw new NoSuchElementException();
    }
}
