package ru.kpfu.itis.j903.cw.minsafin.inf_4;

import ru.kpfu.itis.j903.cw.minsafin.inf_3.iterators.ModifiableCollectionIterator;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class ModifiableCollection<T> extends AbstractCollection<T> {
    private ArrayList<T> data;

    public ModifiableCollection(Collection<? extends T> collection) {
        this.data = new ArrayList<>();
        data.addAll(collection);
    }

    public ModifiableCollection() {
        data = new ArrayList<>();
    }

    @Override
    public boolean add(T t) {
        data.add(t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return data.remove(o);
    }

    @Override
    public Iterator<T> iterator() {
        return new ModifiableCollectionIterator<T>(data);
    }

    @Override
    public int size() {
        return data.size();
    }
}
