package me.jeffrey.algorithms.base.chapter2;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;
import java.util.Random;

/**
 * SelectionSort Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>八月 3, 2017</pre>
 */
public class SelectionSortTest {
    private int[] test;

    @Before
    public void before() throws Exception {

        Random random = new Random();
        int arrayLength = 20;
        test = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            test[i] = random.nextInt(arrayLength * 10);
        }

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: selectionSort(int[] input)
     */
    @Test
    public void testSelectionSort() throws Exception {
        System.out.println(Arrays.toString(test));
        SelectionSort.selectionSort(test);
        System.out.println(Arrays.toString(test));
        for (int i = 0; i < test.length - 1; i++) {
            assert test[i] <= test[i + 1];
        }


    }
}
