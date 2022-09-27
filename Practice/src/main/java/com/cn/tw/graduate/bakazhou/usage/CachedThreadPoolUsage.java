package com.cn.tw.graduate.bakazhou.usage;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolUsage {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Set<Long> threadSet = new HashSet<>();
        Object lock = new Object();
        for (int i = 0; i < 5; i++) {
            cachedThreadPool.execute(() -> {
                synchronized (lock){
                    System.out.println("Current thread id:"+Thread.currentThread().getId());
                    threadSet.add(Thread.currentThread().getId());
                    System.out.println("Current thread name:"+Thread.currentThread().getName());
                    System.out.println();
                }
            });
        }

        Thread.sleep(5000);
        cachedThreadPool.execute(() -> {
            System.out.println("Current thread is from cachedThreadPool："+threadSet.contains(Thread.currentThread().getId()));
            System.out.println("Current thread id:"+Thread.currentThread().getId());
            System.out.println("Current thread name:"+Thread.currentThread().getName());
            System.out.println();
        });

        cachedThreadPool.shutdown();
    }
}
