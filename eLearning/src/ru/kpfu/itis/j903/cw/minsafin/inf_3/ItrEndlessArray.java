package ru.kpfu.itis.j903.cw.minsafin.inf_3;
import ru.kpfu.itis.j903.cw.minsafin.inf_1.endlessarray.EndlessArray;
import ru.kpfu.itis.j903.cw.minsafin.inf_3.iterators.EndlessArrayIterator;


import java.util.Iterator;

public class ItrEndlessArray<T> extends EndlessArray<T> implements Iterable<T> {


    @Override
    public Iterator<T> iterator() {
        return new EndlessArrayIterator<T>(endlessArr, size);
    }
}
