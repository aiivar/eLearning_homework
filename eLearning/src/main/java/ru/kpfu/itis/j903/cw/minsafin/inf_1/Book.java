package ru.kpfu.itis.j903.cw.minsafin.inf_1;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private int pages;
    private String genre;
    private String authorName;

    public Book(int pages, String genre, String authorName) {
        this.pages = pages;
        this.genre = genre;
        this.authorName = authorName;
    }

    @Override
    public int compareTo(Book o) {
        return this.pages - o.pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(authorName, book.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pages, genre, authorName);
    }

    @Override
    public String toString() {
        return "Book{" +
                "pages=" + pages +
                ", genre='" + genre + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }

    public int getPages() {
        return pages;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthorName() {
        return authorName;
    }
}
