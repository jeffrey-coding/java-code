package me.jeffrey.algorithms.base.chapter2;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;
import java.util.Random;

/**
 * MergeSort Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>九月 5, 2017</pre>
 */
public class MergeSortTest {
    private int[] test;


    @Before
    public void before() throws Exception {
        Random random = new Random();
        int arrayLength = 16;
        test = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            test[i] = random.nextInt(arrayLength * 20);
        }
        System.out.println(Arrays.toString(test));
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: mergeSort_1(int[] input, int p, int r)
     */
    @Test
    public void testMergeSort_1() throws Exception {
        MergeSort.mergeSort_1(test,0, test.length);
        System.out.println(Arrays.toString(test));
        for (int i = 0; i < test.length-1; i++) {
            assert test[i] <= test[i+1];
        }
    }


} 
