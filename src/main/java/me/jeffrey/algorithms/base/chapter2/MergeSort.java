package me.jeffrey.algorithms.base.chapter2;

public class MergeSort {
    private static int[] merge(int[] A, int p, int q, int r)
    {
        int n = q - p;
        int m = r - q;
        int[] L = new int[n+1];
        int[] R = new int[m+1];
        for(int i = 0; i < n; i++)
        {
            L[i] = A[p+i];
        }
        for(int i = 0; i < m; i++)
        {
            R[i] = A[q + i];
        }
        L[n] = Integer.MAX_VALUE;
        R[m] = Integer.MAX_VALUE;

//        System.out.println("L is " + Arrays.toString(L));
//        System.out.println("R is " + Arrays.toString(R));
        int i=0,j=0;
        for(int k = p; k < r; k++)
        {
            if(L[i] <= R[j])
            {
                A[k] = L[i];
                i++;
            }else {
                A[k] = R[j];
                j++;
            }
        }

        return A;
    }
    public static void mergeSort_1(int[] input, int p, int r){
        if (p+1 < r){
            int q = (p+r)/2;
            mergeSort_1(input, p, q);
            mergeSort_1(input, q, r);
            merge(input, p, q, r);
        }


    }
}
