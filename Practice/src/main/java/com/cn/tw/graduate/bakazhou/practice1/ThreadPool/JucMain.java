package com.cn.tw.graduate.bakazhou.practice1.ThreadPool;

import com.cn.tw.graduate.bakazhou.practice1.User;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class JucMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Object lock = new Object();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            tasks.add(new Task((long)i));
        }
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(4,8,500, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(1024), threadFactory,new ThreadPoolExecutor.AbortPolicy());
        //获取开始时间
        long startTime = System.currentTimeMillis();

        List<Future<User>> futures;
        synchronized (lock){
            try {
                futures = threadPool.invokeAll(tasks);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                threadPool.shutdown();
            }
        }
        for (Future<User> user : futures) {
            System.out.println("user id:"+user.get().getId());
        }
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("多线程总耗时:" + (endTime - startTime) / 1000 + "s");

    }
}
