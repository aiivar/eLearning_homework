package ru.kpfu.itis.j903.cw.minsafin.algorithmsanddatastructures.ads_6.n_1;

public class MergeSort {

    public int[] sort(int[] arr){
        return mergeSort(arr);
    }

    private int[] mergeSort(int[] arr){
        if (arr == null){
            return null;
        }
        if (arr.length == 1){
            return arr;
        }
        int[] first = new int[arr.length/2];
        int[] second = new int[arr.length - first.length];
        System.arraycopy(arr, 0, first, 0, first.length);
        System.arraycopy(arr, first.length, second, 0, second.length);
        first = mergeSort(first);
        second = mergeSort(second);
        return merge(first, second);
    }

    private int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int cursor1 = 0;
        int cursor2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (!(cursor1 == first.length || cursor2 == second.length)) {
                if (first[cursor1] < second[cursor2]) {
                    result[i] = first[cursor1];
                    cursor1++;
                } else {
                    result[i] = second[cursor2];
                    cursor2++;
                }
            } else {
                if (cursor1 == first.length){
                    System.arraycopy(second, cursor2, result, i, result.length-i);
                    break;
                }else {
                    System.arraycopy(first, cursor1, result, i, result.length-i);
                    break;
                }
            }
        }
        return result;
    }
}
