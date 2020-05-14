package com.thread;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName: InterruptTest
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/4/27 18:19
 * @Version: V0.1
 */
public class InterruptTest {
    static String a = "1";

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(3000);
                System.out.println("ok");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        PriorityQueue<Integer> list = new PriorityQueue<>();

    }
}
