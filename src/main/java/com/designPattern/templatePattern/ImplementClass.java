package com.designPattern.templatePattern;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ImplementClass
 * @Description: 模板模式的实现类
 * @Author: WAHWJ
 * @Date: 2020/4/6 19:23
 * @Version: V0.1
 */
public class ImplementClass extends AbstractClass {
    @Override
    void initialize() {
        System.out.println("initialize");
    }

    @Override
    void procese() {
        System.out.println("processed");
    }

    @Override
    public void end() {
        System.out.println("end by son");
    }

    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = s1.intern();
        System.out.println(s1==s2);
        
    }
}
