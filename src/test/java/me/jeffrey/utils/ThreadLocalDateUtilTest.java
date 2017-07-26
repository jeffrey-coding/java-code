package me.jeffrey.utils;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

/**
 * ThreadLocalDateUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>七月 18, 2017</pre>
 */
public class ThreadLocalDateUtilTest {
    private ExecutorService executor;
    private final Random random = new Random();
    private final int RUN_TIMES = 500;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private class FormatDate implements Runnable {

        @Override
        public void run() {
            long now = System.currentTimeMillis();
            for(int i = 0; i < RUN_TIMES; i++){
                long time = now + random.nextInt(50000);
                String time_str = ThreadLocalDateUtil.formatDate(new Date(time));
                logger.info(Thread.currentThread().getName() + " formate "+ i +" time is :" + time_str);
            }
            logger.info("FormatDate run end");
        }
    }

    private class ParseDateString implements Runnable {

        @Override
        public void run() {
            String now = "2017071817";
            for(int i = 0; i < RUN_TIMES; i++){
                long time=0;
                String time_str = now + String.format("%04d", random.nextInt(10000));
                try {
                    time = ThreadLocalDateUtil.parseDateString(time_str);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                logger.info(Thread.currentThread().getName() + "secendis :" + (System.currentTimeMillis() - time)/1000);
            }
        }
    }



    /**
     * Method: formatDate(Date date)
     */
    @Test
    public void testFormatDate() throws Exception {
        executor = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            executor.execute(new FormatDate());
        }
        executor.shutdown();
        while (!executor.isTerminated())
            sleep(100);
    }

    /**
     * Method: parseDateString(String source)
     */
    @Test
    public void testParseDateString() throws Exception {
        executor = Executors.newCachedThreadPool();
        for(int i = 0; i < 30; i++){
            new ParseDateString().run();
        }
        executor.shutdown();
        while (!executor.isTerminated())
            sleep(100);
    }

} 
