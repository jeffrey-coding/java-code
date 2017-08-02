package me.jeffrey.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 测试多线程任务调度池的用法
 * Created by jeffreysun on 2017/8/2.
 */
public class ScheduledExecutorServiceTest {

    public static void main(String[] args) throws Exception {
        ScheduledExecutorServiceTest test = new ScheduledExecutorServiceTest();
        test.useScheduleAtFixedRate();
//        test.testScheduleAtFixedRate();
    }

    /**
     * 以固定周期定时调度
     */
    public void useScheduleAtFixedRate() {
        ScheduledExecutorService timer = Executors.newScheduledThreadPool(2);

        TimerTask timerTask = new TimerTask(2000, "task1"); // 任务需要 2000 ms 才能执行完毕

        System.out.printf("起始时间：%s\n\n", new SimpleDateFormat("HH:mm:ss").format(new Date()));

        // 延时 1 秒后，按 3 秒的周期执行任务
        timer.scheduleAtFixedRate(timerTask, 1, 3, TimeUnit.SECONDS);

    }

    /**
     * 固定频率调度
     * 当线程数较大，单个任务耗时比周期长情况
     */
    public void testScheduleAtFixedRate() {
        ScheduledExecutorService timer = Executors.newScheduledThreadPool(2);

        TimerTask timerTask = new TimerTask(4000, "task1"); // 任务需要 4000 ms 才能执行完毕

        System.out.printf("起始时间：%s\n\n", new SimpleDateFormat("HH:mm:ss").format(new Date()));

        // 延时 1 秒后，按 3 秒的周期执行任务
        timer.scheduleAtFixedRate(timerTask, 1, 3, TimeUnit.SECONDS);

    }

    /**
     * 固定频率调度
     * 线程池中多个任务
     */
    public void testScheduleAtFixedRate2() {
        ScheduledExecutorService timer = Executors.newScheduledThreadPool(3);

        TimerTask timerTask1 = new TimerTask(2000, "task1"); // 任务需要 2000 ms 才能执行完毕
        TimerTask timerTask2 = new TimerTask(2000, "task2"); // 任务需要 2000 ms 才能执行完毕

        System.out.printf("起始时间：%s\n\n", new SimpleDateFormat("HH:mm:ss").format(new Date()));

        // 延时 1 秒后，按 3 秒的周期执行任务
        timer.scheduleAtFixedRate(timerTask1, 1, 3, TimeUnit.SECONDS);
        timer.scheduleAtFixedRate(timerTask2, 1, 3, TimeUnit.SECONDS);

    }

    /**
     * 固定频率调度
     * 线程池中多个任务，线程不够的情况
     */
    public void testScheduleAtFixedRate3() {
        ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);

        TimerTask timerTask1 = new TimerTask(2000, "task1"); // 任务需要 2000 ms 才能执行完毕
        TimerTask timerTask2 = new TimerTask(2000, "task2"); // 任务需要 2000 ms 才能执行完毕

        System.out.printf("起始时间：%s\n\n", new SimpleDateFormat("HH:mm:ss").format(new Date()));

        // 延时 1 秒后，按 3 秒的周期执行任务
        timer.scheduleAtFixedRate(timerTask1, 1, 3, TimeUnit.SECONDS);
        timer.scheduleAtFixedRate(timerTask2, 1, 3, TimeUnit.SECONDS);

    }

    /**
     * 以固定延时调度
     */
    public void useScheduleWithFixedDelay() {
        ScheduledExecutorService timer = Executors.newScheduledThreadPool(2);

        TimerTask timerTask = new TimerTask(2000, "task1"); // 任务需要 2000 ms 才能执行完毕

        System.out.printf("起始时间：%s\n\n", new SimpleDateFormat("HH:mm:ss").format(new Date()));

        // 延时 1 秒后，任务完成后3S再运行
        timer.scheduleWithFixedDelay(timerTask, 1, 3, TimeUnit.SECONDS);

    }



    private static class TimerTask implements Runnable {

        private final int sleepTime;
        private final SimpleDateFormat dateFormat;
        private final String taskName;

        public TimerTask(int sleepTime, String name) {
            this.sleepTime = sleepTime;
            this.taskName = name;
            dateFormat = new SimpleDateFormat("HH:mm:ss");
        }

        @Override
        public void run() {
            System.out.println("任务[" + taskName + "]开始，当前时间：" + dateFormat.format(new Date()));

            try {
                System.out.println("模拟任务[" + taskName + "]运行...");
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {
                ex.printStackTrace(System.err);
            }

            System.out.println(Thread.currentThread().getName() + "任务[" + taskName + "]开始，当前时间：" + dateFormat.format(new Date()));
            System.out.println();
        }

    }
}
