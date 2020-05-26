package ru.kpfu.itis.j903.cw.minsafin.inf_4;

import ru.kpfu.itis.j903.cw.minsafin.inf_3.iterators.UnmodifiableCollectionIterator;


import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


public class UnmodifiableCollection<T> extends AbstractCollection<T> {
    private T[] data;

    public UnmodifiableCollection(Collection<? extends T> collection) {
        this.data = (T[]) new Object[collection.size()];
        Iterator<? extends T> iterator = collection.iterator();
        int i = 0;
        while (iterator.hasNext()){
            data[i] = iterator.next();
            i++;
        }
    }

    public UnmodifiableCollection() {
        data = (T[]) new Object[0];
    }

    @Override
    public Iterator<T> iterator() {
        return new UnmodifiableCollectionIterator<T>(data);
    }

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnmodifiableCollection<?> that = (UnmodifiableCollection<?>) o;
        return Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}
