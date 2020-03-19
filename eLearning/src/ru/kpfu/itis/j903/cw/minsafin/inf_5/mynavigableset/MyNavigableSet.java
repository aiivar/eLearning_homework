package ru.kpfu.itis.j903.cw.minsafin.inf_5.mynavigableset;


import java.util.*;

public class MyNavigableSet<T> extends AbstractSet<T> implements NavigableSet<T> {
    private ArrayList<T> data = new ArrayList<>();
    private final Comparator<? super T> comparator;

    public MyNavigableSet(Collection<? extends T> collection, Comparator<? super T> comparator) {
        this.comparator = comparator;
        this.addAll(collection);
    }

    public MyNavigableSet(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public MyNavigableSet(SortedSet<T> sortedSet) {
        this.comparator = sortedSet.comparator();
        data.addAll(sortedSet);
    }


    @Override
    public boolean add(T t) {
        if (data.size() == 0) {
            data.add(t);
            return true;
        }
        if (contains(t)) {
            return false;
        }
        int i = 0;
        for (T e : data) {
            if (comparator.compare(e, t) > 0) {
                data.add(data.indexOf(e), t);
                return true;
            }
        }
        data.add(t);
        return true;
    }


    @Override
    public T lower(T t) {
        int count = -1;
        for (T e : data) {
            if (comparator.compare(e, t) < 0) {
                count++;
            }
        }
        if (count != -1) {
            return data.get(count);
        }
        return null;
    }

    @Override
    public T higher(T t) {
        for (T e : data) {
            if (comparator.compare(e, t) > 0) {
                return e;
            }
        }
        return null;
    }

    @Override
    public T floor(T t) {
        int count = -1;
        for (T e : data) {
            if (comparator.compare(e, t) <= 0) {
                count++;
            }
        }
        if (count != -1) {
            return data.get(count);
        }
        return null;
    }

    @Override
    public T ceiling(T t) {
        for (T e : data) {
            if (comparator.compare(e, t) >= 0) {
                return e;
            }
        }
        return null;
    }


    @Override
    public T pollFirst() {
        return data.remove(0);
    }

    @Override
    public T pollLast() {
        return data.remove(data.size() - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }

    @Override
    public NavigableSet<T> descendingSet() {
        return new MyNavigableSet<T>(data, comparator.reversed());
    }

    @Override
    public Iterator<T> descendingIterator() {
        return descendingSet().iterator();
    }

    @Override
    public NavigableSet<T> subSet(T fromElement, boolean fromInclusive, T toElement, boolean toInclusive) {
        ArrayList<T> newList = new ArrayList<>();
        int i, j;
        i = fromInclusive ? data.indexOf(ceiling(fromElement)) : data.indexOf(higher(fromElement));
        j = toInclusive ? data.indexOf(floor(toElement)) : data.indexOf(lower(toElement));
        for (; i <= j; i++) {
            newList.add(data.get(i));
        }
        return new MyNavigableSet<T>(newList, comparator);
    }

    @Override
    public NavigableSet<T> headSet(T toElement, boolean inclusive) {
        return subSet(first(), true, toElement, inclusive);
    }

    @Override
    public NavigableSet<T> tailSet(T fromElement, boolean inclusive) {
        return subSet(fromElement, inclusive, last(), true);
    }

    @Override
    public Comparator<? super T> comparator() {
        return comparator;
    }

    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        return subSet(fromElement, true, toElement, false);
    }

    @Override
    public SortedSet<T> headSet(T toElement) {
        return headSet(toElement, false);
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        return tailSet(fromElement, true);
    }

    @Override
    public T first() {
        return data.get(0);
    }

    @Override
    public T last() {
        return data.get(data.size() - 1);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public String toString() {
        return "MyNavigableSet{" + data.toString() + "}";
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
