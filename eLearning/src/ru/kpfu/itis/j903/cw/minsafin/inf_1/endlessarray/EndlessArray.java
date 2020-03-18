package ru.kpfu.itis.j903.cw.minsafin.inf_1.endlessarray;

import ru.kpfu.itis.j903.cw.minsafin.inf_1.endlessarray.exceptions.EndlessArrayNonExistentValueException;
import ru.kpfu.itis.j903.cw.minsafin.inf_1.endlessarray.exceptions.EndlessArrayOutOfBoundsException;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Endless Array made by aivarminsafin@gmail.com
 */
public class EndlessArray <T> {
    protected static final int INITIAL_CAPACITY = 10;
    protected int size;
    protected Object[] endlessArr;
    protected int delta = 5;

    /**
     * Constructor with user's capacity
     * @param capacity of created Endless Array
     */
    public EndlessArray(int capacity) {
        this.endlessArr = new Object[capacity];
        this.size = 0;
    }

    /**
     * Default Constructor (Initial capacity = 10)
     */
    public EndlessArray() {
        this.endlessArr = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    /**
     * Array of int values can be copied to EndlessArray
     * @param arr Array of int values
     */
    public EndlessArray(Object[] arr) {
        this.endlessArr = Arrays.copyOf(arr, arr.length);
        this.size = arr.length;
    }

    /**
     * Adding new element with value = a
     * @param a new element's value
     */
    public void add(T a) {
        if (size == endlessArr.length) {
            Object[] newEndlessArr = new Object[endlessArr.length + delta];
            for (int i = 0; i < endlessArr.length; i++) {
                newEndlessArr[i] = endlessArr[i];
            }
            endlessArr = newEndlessArr;
        }
        endlessArr[size] = a;
        size++;
    }

    /**
     * Removing element with n index and EndlessArray shifting
     * @param n index
     * @throws EndlessArrayOutOfBoundsException()
     */
    public void remove(int n) throws EndlessArrayOutOfBoundsException {
        if (validateIndex(n)) {
            for (int i = n; i < size - 1; i++) {
                endlessArr[i] = endlessArr[i + 1];
            }
            endlessArr[size - 1] = 0;
            size--;
            if (endlessArr.length >= size + delta) {
                Object[] newEndlessArr = new Object[endlessArr.length - delta];
                for (int i = 0; i < size; i++) {
                    newEndlessArr[i] = endlessArr[i];
                }
                endlessArr = newEndlessArr;
            }
        } else {
            throw new EndlessArrayOutOfBoundsException();
        }
    }

    /**
     * Getting element's value with n index
     * @param n index
     * @return Returning element's value with n index or throwing "EndlessArrayOutOfBoundsException()"
     * @throws EndlessArrayOutOfBoundsException()
     */
    public T get(int n) {
        if (validateIndex(n)) {
            return (T) endlessArr[n];
        } else {
            throw new EndlessArrayOutOfBoundsException();
        }
    }

    /**
     * Getting index of first encountered element with this value
     * @param value element's value
     * @return Returning element's index with this value or throwing "EndlessArrayNonExistentValueException()"
     * @throws EndlessArrayNonExistentValueException()
     */
    public int getIndexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (endlessArr[i].equals(value)) {
                return i;
            }
        }
        throw new EndlessArrayNonExistentValueException();
    }

    /**
     * Size getter
     * @return Current size
     */
    public int getSize() {
        return size;
    }

    /**
     * Equals
     * @param o object
     * @return Equals or not (boolean)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndlessArray that = (EndlessArray) o;
        boolean equal = true;
        for (int i = 0; i < this.size; i++) {
            if (!that.endlessArr[i].equals(this.endlessArr[i])) {
                equal = false;
                break;
            }
        }
        return size == that.size && equal;
    }

    /**
     * hashCode
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(size, delta);
        result = 31 * result + Arrays.hashCode(endlessArr);
        return result;
    }

    /**
     * toString
     * @return turning EndlessArray to String
     */
    @Override
    public String toString() {
        return "EndlessArr{" +
                "size=" + size + "/" + endlessArr.length +
                ", endlessArr=" + Arrays.toString(endlessArr) +
                '}';
    }

    /**
     * Index existence check
     * @param i Index of Endless Array
     * @return Validated or not (boolean)
     */
    // TECH
    private boolean validateIndex(int i) {
        return i >= 0 && i < size;
    }
}
