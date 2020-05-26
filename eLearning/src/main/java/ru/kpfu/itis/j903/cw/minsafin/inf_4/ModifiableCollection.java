package ru.kpfu.itis.j903.cw.minsafin.inf_4;

import ru.kpfu.itis.j903.cw.minsafin.inf_3.iterators.ModifiableCollectionIterator;

import java.util.*;


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
        return data.add(t);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModifiableCollection<?> that = (ModifiableCollection<?>) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
