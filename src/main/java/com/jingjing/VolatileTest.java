package com.jingjing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VolatileTest {

    public int count = 0;

    public static void main(String[] args) throws InterruptedException {
        VolatileTest v=new VolatileTest();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        new Thread(new Counter1(v),"Thread1").start();
        new Thread(new Counter1(v),"Thread2").start();
        new Thread(new Counter1(v),"Thread3").start();

        // 关闭启动线程，执行未完成的任务

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println(v.count);
    }


}

class Counter1 implements Runnable {
    VolatileTest v;

    public Counter1(VolatileTest v) {
        this.v = v;
    }

    public void run() {
        int time = 10;
        synchronized (v) {
            for (int i = 0; i < time; i++) {
                v.count++;
            }
        }
    }
}
