package me.jeffrey.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jeffreysun on 2017/8/4.
 */
public class Slf4jTest {
    private static Logger LOG = LoggerFactory.getLogger(Slf4jTest.class);
    private static long times = 100000L;
    static long start;
    static long end;

    static void test1(){
        start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            LOG.debug("");
        }
        end = System.currentTimeMillis();
        System.out.println("test1 using time "+ (end-start));
    }

    static void test2(){
        start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            ;
        }
        end = System.currentTimeMillis();
        System.out.println("test2 using time "+ (end-start));
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
