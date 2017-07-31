package me.jeffrey.algorithms.base.chapter2; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.util.Arrays;
import java.util.Random;

/** 
* InsertSort Tester. 
* 
* @author <Authors name> 
* @since <pre>七月 31, 2017</pre> 
* @version 1.0 
*/ 
public class InsertSortTest {
    Random random ;
    Integer[] test;

    @Before
    public void before() throws Exception {
        random = new Random();
        test = new Integer[10];
        for (int i = 0; i < 10; i++) {
            test[i] = random.nextInt(1000);
        }
    }

    @After
    public void after() throws Exception {
        System.out.println("test end");
    }

    /**
     * 测试插入排序 升序
     * Method: insertSort(Comparable[] input)
     */
    @Test
    public void testInsertSort() throws Exception {
        System.out.println(Arrays.toString(test));
        InsertSort.insertSort(test);
        System.out.println(Arrays.toString(test));
        for (int i = 0; i < test.length-1; i++) {
            assert test[i] <= test[i+1];
        }
    }

/**
*
* Method: insertSortDesc(Comparable[] input)
*
*/
@Test
public void testInsertSortDesc() throws Exception {
    System.out.println(Arrays.toString(test));
    InsertSort.insertSortDesc(test);
    System.out.println(Arrays.toString(test));
    for (int i = 0; i < test.length-1; i++) {
        assert test[i] >= test[i+1];
    }
}


}
