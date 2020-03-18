package ru.kpfu.itis.j903.cw.minsafin.inf_3.iterators.hm;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenStringArrayIterator implements Iterator<String> {
    private String[] data;
    private int cursor;
    private int i;
    private boolean finished;

    public EvenStringArrayIterator(String[] data) {
        this.data = data;
        this.cursor = 0;
        this.finished = false;
        this.i = 0;
    }

    @Override
    public boolean hasNext() {
        if (data.length <= cursor + i) {
            return false;
        }
        if (data[cursor + i] == null) {
            i += 2;
            return hasNext();
        }
        return true;
    }

    @Override
    public String next() {
        try {
            if (hasNext()) {
                cursor = cursor + i;
                i = 0;
                String el = data[cursor];
                cursor += 2;
                return el;
            } else {
                throw new NoSuchElementException();
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new NoSuchElementException();
        }
    }
}
