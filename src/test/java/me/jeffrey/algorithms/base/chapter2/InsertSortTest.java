package me.jeffrey.algorithms.base.chapter2; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.util.Arrays;

/** 
* InsertSort Tester. 
* 
* @author <Authors name> 
* @since <pre>七月 31, 2017</pre> 
* @version 1.0 
*/ 
public class InsertSortTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: insertSort(Comparable[] input)
     */
    @Test
    public void testInsertSort() throws Exception {
        Integer[] test = {2, 9, 3, 6, 1};
        System.out.println(Arrays.toString(test));
        InsertSort.insertSort(test);
        System.out.println("====end=====");
        for (int i = 0; i < test.length-1; i++) {
            assert test[i] <= test[i+1];
        }
    }

}