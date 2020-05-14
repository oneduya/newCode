package com.jingjing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    public AtomicInteger count = new AtomicInteger(0);

    /**
     * 这里模拟一个递增的任务，递增目标为50000
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        AtomicCounter incrementTest = new AtomicCounter();

        for (int i = 0; i < 500; i++) {
            executor.execute(new Counter(incrementTest));
        }

        // 关闭启动线程，执行未完成的任务
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println(incrementTest.count.get());
    }

}

class Counter implements Runnable{
    AtomicCounter incrementTest;

    public Counter(AtomicCounter incrementTest) {
        this.incrementTest = incrementTest;
    }

    public void run() {
        incrementTest.count.incrementAndGet();
    }

}