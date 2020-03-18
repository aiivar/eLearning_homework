package ru.kpfu.itis.j903.cw.minsafin.inf_2;

import java.util.Comparator;

public class BookAuthorComparator implements Comparator<Book> {

    public int compare(Book o1, Book o2) {
        return o1.getAuthorName().compareTo(o2.getAuthorName());
    }
}
