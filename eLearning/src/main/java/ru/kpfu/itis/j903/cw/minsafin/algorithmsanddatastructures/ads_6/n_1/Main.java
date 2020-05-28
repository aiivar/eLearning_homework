package ru.kpfu.itis.j903.cw.minsafin.algorithmsanddatastructures.ads_6.n_1;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 41, 2, 5, 7};
        MergeSort sort = new MergeSort();
         arr = sort.sort(arr);
        for (int a: arr) {
            System.out.println(a);
        }
    }
}
