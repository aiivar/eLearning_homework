package ru.kpfu.itis.j903.cw.minsafin.inf_3.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringArrayIterator implements Iterator<String> {
    private String[] data;
    private int cursor;

    public StringArrayIterator(String[] data) {
        this.data = data;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        if (data.length <= cursor) {
            return false;
        }
        return true;
    }

    @Override
    public String next() {
        try {
            String el = data[cursor];
            cursor++;
            return el;
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new NoSuchElementException();
        }
    }
}
