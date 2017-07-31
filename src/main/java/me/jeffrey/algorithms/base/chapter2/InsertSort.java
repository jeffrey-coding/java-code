package me.jeffrey.algorithms.base.chapter2;


import java.util.Arrays;

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
        System.out.println(Arrays.toString(input));
    }

    public static void main(String[] args) {
        Integer[] test = {2,9,3,6,1};
        System.out.println(Arrays.toString(test));
        InsertSort.insertSort(test);
        System.out.println("====end=====");
    }
}
