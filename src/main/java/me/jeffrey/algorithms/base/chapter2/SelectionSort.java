package me.jeffrey.algorithms.base.chapter2;

class SelectionSort {
    private static void swap(int[] input, int a, int b){
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
    static void selectionSort(int[] input){
        for (int i = 0; i < input.length-1; i++) {
            int tempMin = i;
            for (int j = i; j < input.length; j++) {
                if(input[tempMin] >= input[j])
                    tempMin = j;
            }
            swap(input, i, tempMin);
        }
    }
}
