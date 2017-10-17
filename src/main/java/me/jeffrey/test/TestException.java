package me.jeffrey.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestException {
    public static final Logger logger = LoggerFactory.getLogger(TestException.class);

    public static void f(int i) throws Exception{
        throw new Exception("出问题啦！" + i);
    }

    static void g(int i) throws Exception{
        f(i);
    }
    static void h(int i) throws Exception{
        g(i);
    }
    static void j(int i) throws Exception{
        h(i);
    }

    public static String p() {
        return new String("出问题啦！");
    }

    static void test(){
        long start ;
        long end ;
        int times = 100000;
        try {
            f(10000);
        }catch (Exception e){
            logger.debug("get error", e);
        }

        start = System.currentTimeMillis();
        for(int i=times; i > 0; i--){
            logger.debug(p());
        }
        end = System.currentTimeMillis();
        long test1 = end - start;

        start = System.currentTimeMillis();
        for(int i=times; i > 0; i--){
            logger.debug(p());
        }
        end = System.currentTimeMillis();
        test1 = end - start;

        start = System.currentTimeMillis();
        for(int i=times; i > 0; i--){
            try {
                f(i + times);
            }catch (Exception e){
                logger.debug("get error", e);
            }
        }
        end = System.currentTimeMillis();
        long test2 = end - start;

        start = System.currentTimeMillis();
        for(int i=times; i > 0; i--){
            try {
                f(i);
            }catch (Exception e){
                logger.debug("get error");
            }
        }
        end = System.currentTimeMillis();
        long test3 = end - start;

        start = System.currentTimeMillis();
        for(int i=times; i > 0; i--){
            try {
                f(i);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        end = System.currentTimeMillis();
        long test4 = end - start;


        start = System.currentTimeMillis();
        for(int i=times; i > 0; i--){
            logger.debug(p());
        }
        end = System.currentTimeMillis();
        long test11 = end - start;

        start = System.currentTimeMillis();
        for(int i=times; i > 0; i--){
            try {
                j(i + times);
            }catch (Exception e){
                logger.debug("get error", e);
            }
        }
        end = System.currentTimeMillis();
        long test12 = end - start;

        start = System.currentTimeMillis();
        for(int i=times; i > 0; i--){
            try {
                j(i);
            }catch (Exception e){
                logger.debug("get error");
            }
        }
        end = System.currentTimeMillis();
        long test13 = end - start;

        start = System.currentTimeMillis();
        for(int i=times; i > 0; i--){
            try {
                j(i);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        end = System.currentTimeMillis();
        long test14 = end - start;




        logger.info("test1 using {} ms" , test1);
        logger.info("test2 using {} ms" , test2);
        logger.info("test3 using {} ms" , test3);
        logger.info("test4 using {} ms" , test4);

        logger.info("test11 using {} ms" , test11);
        logger.info("test12 using {} ms" , test12);
        logger.info("test13 using {} ms" , test13);
        logger.info("test14 using {} ms" , test14);
    }

    static void testMapGetNullKey(){
        Map<String, String> map1 = new ConcurrentHashMap<String,String>();
        map1.put("k1","v1");
        map1.put("k2","v2");
        map1.put("k3","v3");
        map1.put("k4","v4");
        logger.info("map1 key {} value is {}", "k1", map1.get("k1"));
        logger.info("map1 key {} value is {}", "k5", map1.get("k5"));
    }

    public static void main(String[] args) {
//        test();
        testMapGetNullKey();
    }
}
