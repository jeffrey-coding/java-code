package me.jeffrey.algorithms.base.chapter2;


public class InsertSort {
    public static void insertSort(Comparable[] input){
        long len = input.length;
        for(int j = 1; j < len; j++){
            Comparable key = input[j];
            int i = j - 1;
            while (i >= 0 && input[i].compareTo(key) > 0){
                input[i+1] = input[i];
                i = i - 1;
            }
            input[i+1] = key;
        }

    }

    public static void insertSortDesc(Comparable[] input){
        long len = input.length;
        for(int j = 1; j < len; j++){
            Comparable key = input[j];
            int i = j - 1;
            while (i >= 0 && input[i].compareTo(key) < 0){
                input[i+1] = input[i];
                i = i - 1;
            }
            input[i+1] = key;
        }

    }


}
