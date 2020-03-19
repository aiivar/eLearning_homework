package ru.kpfu.itis.j903.cw.minsafin.inf_3.iterators;

import ru.kpfu.itis.j903.cw.minsafin.inf_3.CanNotRemoveThisElementException;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ModifiableCollectionIterator<T> implements Iterator<T> {
    protected T[] data;
    protected int cursor;

    public ModifiableCollectionIterator(Collection<? extends T> collection) {
        data = (T[]) collection.toArray();
        cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return data.length > cursor;
    }

    @Override
    public void remove() {
        if (data[cursor] != null){
            data[cursor] = null;
        }
        throw new CanNotRemoveThisElementException();
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
