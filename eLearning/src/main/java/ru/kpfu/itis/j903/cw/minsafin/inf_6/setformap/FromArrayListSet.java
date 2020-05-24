package ru.kpfu.itis.j903.cw.minsafin.inf_6.setformap;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class FromArrayListSet<T> extends AbstractSet<T> {
    private ArrayList<T> set;

    public FromArrayListSet() {
        set = new ArrayList<>();
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }

    @Override
    public boolean add(T e) {
        if (this.contains(e)) {
            return false;
        }
        set.add(e);
        return true;
    }

    @Override
    public boolean contains(Object e) {
        return set.contains(e);
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean remove(Object e){
        if (this.contains(e)){
            set.remove(e);
            return true;
        }
        return false;
    }

}
