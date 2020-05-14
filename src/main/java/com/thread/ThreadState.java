package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadState implements Callable<Integer> {


    public Integer call() throws InterruptedException {
        System.out.println("正在进行计算");
        Thread.sleep(2000);
        return 1;
    }

    public static void main(String[] args) throws InterruptedException {
    }
}
