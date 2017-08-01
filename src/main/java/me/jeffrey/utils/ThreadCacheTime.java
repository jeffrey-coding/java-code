package me.jeffrey.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 缓存当前时间，提供其他线程使用，降低多线程达并发情况下对于时间处理的资源消耗
 * 使用的时候有可能 nowTime 与 nowTimeString 不相同，变量赋值有时间窗口
 * Created by jeffreysun on 2017/7/31.
 */
public class ThreadCacheTime {
    private static ThreadCacheTime instance = new ThreadCacheTime();
    private static volatile TimeRecord timeRecord = new TimeRecord();
    private ScheduledThreadPoolExecutor executor;


    private ThreadCacheTime() {
        this.executor = new ScheduledThreadPoolExecutor(1);
        this.executor.scheduleAtFixedRate(new Runnable() {
            public void run() {
                timeRecord = new TimeRecord(System.currentTimeMillis());
            }
        }, 0, 500, TimeUnit.MILLISECONDS);
    }

    public static ThreadCacheTime getInstance() {
        return instance;
    }

    public long getNowTime() {
        return timeRecord.getTimeLong();
    }

    public String getNowTimeStr() {
        return timeRecord.getTimeString();
    }

    public static void test1() {
        class Test implements Runnable {
            private Thread t;
            private String threadName;

            public Test(String threadName) {
                this.threadName = threadName;
            }

            @Override
            public void run() {
                long num = 1000000;
                long now = System.currentTimeMillis();
                ThreadCacheTime ct = ThreadCacheTime.getInstance();
                while (num > 0) {
                    long time = ct.getNowTime();
                    String time_str = ct.getNowTimeStr();
                    num--;
                }
                System.out.println("test1 using time " + (System.currentTimeMillis() - now));
            }

            public void start() {
                System.out.println("Starting " + threadName);
                if (t == null) {
                    t = new Thread(this, threadName);
                    t.start();
                }
            }
        }
        Test t1 = new Test("thread 11");
        Test t2 = new Test("thread 12");
        Test t3 = new Test("thread 13");
        Test t4 = new Test("thread 14");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public static void test2() {
        class Test implements Runnable {
            private Thread t;
            private String threadName;

            public Test(String threadName) {
                this.threadName = threadName;
            }

            @Override
            public void run() {
                long num = 1000000;
                long start = System.currentTimeMillis();
                while (num > 0) {
                    long time = System.currentTimeMillis();
                    String time_str = ThreadLocalDateUtil.formatDate(new Date(time));
                    num--;
                }
                System.out.println("test2 using time " + (System.currentTimeMillis() - start));
            }

            public void start() {
                System.out.println("Starting " + threadName);
                if (t == null) {
                    t = new Thread(this, threadName);
                    t.start();
                }
            }
        }
        Test t1 = new Test("thread 21");
        Test t2 = new Test("thread 22");
        Test t3 = new Test("thread 23");
        Test t4 = new Test("thread 24");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public static void main(String[] args) {
        test1();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test2();
    }
}

class TimeRecord {
    private long timeLong;
    private String timeString;
    private static final SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

    public TimeRecord(long timeLong, String timeString) {
        this.timeLong = timeLong;
        this.timeString = timeString;
    }

    public TimeRecord() {
        this.timeLong = System.currentTimeMillis();
        this.timeString = df.format(new Date(timeLong));
    }

    public TimeRecord(long timeLong) {
        this.timeLong = timeLong;
        this.timeString = df.format(new Date(timeLong));
    }

    public long getTimeLong() {
        return timeLong;
    }

    public String getTimeString() {
        return timeString;
    }
}