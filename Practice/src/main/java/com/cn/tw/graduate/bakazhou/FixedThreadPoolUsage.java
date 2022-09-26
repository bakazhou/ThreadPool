package com.cn.tw.graduate.bakazhou;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolUsage {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        Object lock = new Object();
        Set<Long> threadSet = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            fixedThreadPool.execute(() -> {
                synchronized (lock){
                    System.out.println("Current thread id:"+Thread.currentThread().getId());
                    threadSet.add(Thread.currentThread().getId());
                    System.out.println("Current thread name:"+Thread.currentThread().getName());
                    System.out.println();
                }
            });
        }
        Thread.sleep(3000);
        System.out.println("Thread pool size is:"+threadSet.size());
        System.out.println();
        fixedThreadPool.execute(() -> {
            System.out.println("Current thread is from cachedThreadPool："+threadSet.contains(Thread.currentThread().getId()));
            System.out.println("Current thread id:"+Thread.currentThread().getId());
            System.out.println("Current thread name:"+Thread.currentThread().getName());
            System.out.println();
        });
    }
}
