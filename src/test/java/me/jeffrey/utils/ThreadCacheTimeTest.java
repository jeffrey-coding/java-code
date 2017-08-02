package me.jeffrey.utils; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* ThreadCacheTime Tester. 
* 
* @author <Authors name> 
* @since <pre>八月 1, 2017</pre> 
* @version 1.0 
*/ 
public class ThreadCacheTimeTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}

/** 
* 
* Method: getNowTime() 
* 
*/ 
@Test
public void test() throws Exception {
    int num = 30;
    ThreadCacheTime cacheTime = ThreadCacheTime.getInstance();
    while (num > 0){
        System.out.println("now time is "+ cacheTime.getNowTimeStr() + " the long is " + cacheTime.getNowTime());
        num--;
        Thread.sleep(100);
    }
} 




} 
