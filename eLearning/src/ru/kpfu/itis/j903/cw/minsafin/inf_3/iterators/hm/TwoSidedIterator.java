package ru.kpfu.itis.j903.cw.minsafin.inf_3.iterators.hm;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoSidedIterator<T> implements Iterator<T> {
    private T[] data;
    private boolean side;
    private int headCursor;
    private int tailCursor;

    public TwoSidedIterator(Object[] data) {
        this.data = (T[]) data;
        headCursor = 0;
        tailCursor = this.data.length-1;
        side = false;
    }

    @Override
    public boolean hasNext() {
        if (!side) {
            if (data.length / 2 > headCursor){
                if (data[headCursor+1] != null){
                    return true;
                }
            }else {
                return false;
            }
        }else {
            if (data.length / 2 < tailCursor){
                if (data[tailCursor-1] != null){
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public T next() {
        if (hasNext()){
            if (!side){
                return data[headCursor];
            }
            return data[tailCursor];
        }
        throw new NoSuchElementException();
    }
}
