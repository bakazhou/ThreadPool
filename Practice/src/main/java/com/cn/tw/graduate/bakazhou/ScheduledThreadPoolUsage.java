package com.cn.tw.graduate.bakazhou;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolUsage {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        Object lock = new Object();
        Set<Long> threadSet = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            Thread.sleep(1000);
            scheduledThreadPool.schedule(() -> {
                synchronized (lock){
                    System.out.println("Current thread id:"+Thread.currentThread().getId());
                    threadSet.add(Thread.currentThread().getId());
                    System.out.println("Now time is:"+ LocalDateTime.now());
                    System.out.println();
                }
            },3, TimeUnit.SECONDS);
            Thread.sleep(1000);
        }

        System.out.println("Thread pool size is:"+threadSet.size());
        scheduledThreadPool.shutdown();
    }
}
