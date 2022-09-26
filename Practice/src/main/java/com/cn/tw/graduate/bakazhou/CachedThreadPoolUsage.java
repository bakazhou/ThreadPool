package com.cn.tw.graduate.bakazhou;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolUsage {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Object lock = new Object();
        for (int i = 0; i < 5; i++) {
            cachedThreadPool.execute(() -> {
                synchronized (lock){
                    System.out.println("Current thread id:"+Thread.currentThread().getId());
                    System.out.println("Current thread name:"+Thread.currentThread().getName());
                    System.out.println();
                }
            });
        }

        Thread.sleep(5000);
        cachedThreadPool.execute(() -> {
            System.out.println("Current thread id:"+Thread.currentThread().getId());
            System.out.println("Current thread name:"+Thread.currentThread().getName());
            System.out.println();
        });

        cachedThreadPool.shutdown();
    }
}
