package me.jeffrey.test; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.util.Map;

/** 
* StringSplite Tester. 
* 
* @author <Authors name> 
* @since <pre>八月 1, 2017</pre> 
* @version 1.0 
*/ 
public class StringSpliteTest {
    long startTime,endTime;
    final long loop = 100000;

@Before
public void before() throws Exception {
    System.out.println(System.getProperty("java.version"));
} 

@After
public void after() throws Exception {
    System.out.println("using time " + (endTime - startTime)/ 1000.0);
} 

/** 
* 
* Method: splite() 
* 
*/ 
@Test
public void testSplit() throws Exception {
    System.out.println("======= start testSplit =========");
    System.out.println(StringSplite.split().toString());
    startTime = System.currentTimeMillis();
    long num = loop;
    while (num>0){
        Map<String,String> res = StringSplite.split();
        num--;
    }
    endTime = System.currentTimeMillis();
} 

/** 
* 
* Method: stringTokenizer() 
* 
*/ 
@Test
public void testStringTokenizer() throws Exception {
    System.out.println("======= start testStringTokenizer =========");
    System.out.println(StringSplite.stringTokenizer().toString());
    startTime = System.currentTimeMillis();
    long num = loop;
    while (num>0){
        Map<String,String> res = StringSplite.stringTokenizer();
        num--;
    }
    endTime = System.currentTimeMillis();
}

    /**
     *
     * Method: stringTokenizer()
     *
     */
    @Test
    public void testStringTokenizer2() throws Exception {
        System.out.println("======= start testStringTokenizer =========");
        System.out.println(StringSplite.stringTokenizer2().toString());
        startTime = System.currentTimeMillis();
        long num = loop;
        while (num>0){
            Map<String,String> res = StringSplite.stringTokenizer2();
            num--;
        }
        endTime = System.currentTimeMillis();
    }

    /**
* 
* Method: splitter() 
* 
*/ 
@Test
public void testSplitter() throws Exception {
    System.out.println("======= start testSplitter =========");
    System.out.println(StringSplite.splitter().toString());
    startTime = System.currentTimeMillis();
    long num = loop;
    while (num>0){
        Map<String,String> res = StringSplite.splitter();
        num--;
    }
    endTime = System.currentTimeMillis();
}

    /**
     *
     * Method: splitter()
     *
     */
    @Test
    public void testStringUtilsSplit() throws Exception {
        System.out.println("======= start testStringUtilsplit =========");
        System.out.println(StringSplite.stringUtilsSplit().toString());
        startTime = System.currentTimeMillis();
        long num = loop;
        while (num>0){
            Map<String,String> res = StringSplite.stringUtilsSplit();
            num--;
        }
        endTime = System.currentTimeMillis();
    }

} 
