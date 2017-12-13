package me.jeffrey.test;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试 ConcurrentMap 边遍历，边删除
 * Created by jeffreysun on 2017/7/18.
 */
public class TestConcurrentMapIteration {
    private final Map<String, String> map = new ConcurrentHashMap<String, String>();

    private final static int MAP_SIZE = 500;

    public static void main(String[] args) {

//        new TestConcurrentMapIteration().run();
        ConcurrentHashMap<String, ArrayList<Integer>> testMap = new ConcurrentHashMap<String, ArrayList<Integer>>();
        ArrayList<Integer> testArr = new ArrayList<Integer>();
        testMap.put("test",testArr);
        testMap.get("test").add(1);
        System.out.println(ArrayUtils.toString(testMap.get("test")));
        ArrayList<Integer> testArrTemp  = testMap.get("test");
        testArrTemp.add(2);
        System.out.println(ArrayUtils.toString(testMap.get("test")));
    }

    private TestConcurrentMapIteration() {
        for (int i = 0; i < MAP_SIZE; i++) {
            map.put("key" + i, UUID.randomUUID().toString());
        }

    }

    private final ExecutorService executor = Executors.newCachedThreadPool();

    private final class Accessor implements Runnable {
        private final Map<String, String> map;
        private int readCount = 0;

        private Accessor(Map<String, String> map) {
            this.map = map;
        }

        @Override
        public void run() {
            for (Map.Entry<String, String> entry : this.map.entrySet()) {
                readCount++;
                System.out.println(
                        Thread.currentThread().getName() + " - [" + entry.getKey() + ", " + entry.getValue() + ']'
                );
            }
            System.out.println(Thread.currentThread().getName() + " total read " + readCount);
            System.out.println(Thread.currentThread().getName() +" =====end====");
        }
    }

    private final class Mutator implements Runnable {

        private final Map<String, String> map;

        private Mutator(Map<String, String> map) {
            this.map = map;
        }

        @Override
        public void run() {
            for (int i = 500; i >= 0; i--) {
                System.out.println(Thread.currentThread().getName() + ": remove " + i + ", value=" + this.map.remove("key" + i));
            }
            System.out.println(Thread.currentThread().getName() +" =====end====");
        }
    }

    private void run() {
        Accessor a1 = new Accessor(this.map);
        Accessor a2 = new Accessor(this.map);
        Mutator m = new Mutator(this.map);

        executor.execute(a1);
        executor.execute(m);
        executor.execute(a2);
        executor.shutdown();
    }
}
