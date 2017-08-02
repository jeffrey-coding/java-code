package me.jeffrey.test;

import org.apache.commons.lang.StringUtils;

/**
 * Created by jeffreysun on 2017/8/2.
 */
public class main {
    public static void main(String[] args) {
        String timestamp = "20170802141422";
        long num = 1000000;
        long start = System.currentTimeMillis();
        for(long i = num; i>0;i--){
            StringUtils.left(timestamp, 12);
        }
        long end = System.currentTimeMillis();
        System.out.println("using time " + (end - start));

        start = System.currentTimeMillis();
        for(long i = num; i>0;i--){
            timestamp.substring(0,12);
        }
        end = System.currentTimeMillis();

        System.out.println("using time " + (end - start));
        String timeMine = StringUtils.left(timestamp, 12);
        System.out.println(timeMine);
        String time = StringUtils.rightPad(timeMine,14, '0');
        System.out.println(time);
        System.out.println(timestamp.substring(0,12));
    }
}
