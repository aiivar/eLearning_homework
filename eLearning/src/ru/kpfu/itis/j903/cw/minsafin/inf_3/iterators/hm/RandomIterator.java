package ru.kpfu.itis.j903.cw.minsafin.inf_3.iterators.hm;

import java.util.NoSuchElementException;
import java.util.Random;

public class RandomIterator{

    public RandomIterator() {

    }


    public boolean hasNext() {
        return true;
    }


    public int next() {
        if (hasNext()){
            Random random = new Random();
            return random.nextInt();
        }else {
            throw new NoSuchElementException();
        }
    }
}
