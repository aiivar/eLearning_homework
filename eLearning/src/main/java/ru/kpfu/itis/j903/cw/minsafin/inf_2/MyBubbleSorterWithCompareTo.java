package ru.kpfu.itis.j903.cw.minsafin.inf_2;

public class MyBubbleSorterWithCompareTo<T extends Comparable<T>> {

    public void bubbleSort(T[] numArray) {
        int n = numArray.length;
        T temp = null;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (numArray[j - 1].compareTo((numArray[j])) > 0) {
                    temp = numArray[j - 1];
                    numArray[j - 1] = numArray[j];
                    numArray[j] = temp;
                }
            }
        }
    }
}
