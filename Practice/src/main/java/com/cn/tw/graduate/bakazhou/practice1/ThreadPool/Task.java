package com.cn.tw.graduate.bakazhou.practice1.ThreadPool;

import com.cn.tw.graduate.bakazhou.practice1.User;
import com.cn.tw.graduate.bakazhou.practice1.UserService;

import java.util.concurrent.Callable;

public class Task implements Callable<User> {
    private final Long id;
    public Task(Long id) {
        this.id = id;
    }

    @Override
    public User call() {
        return new UserService().getUser(this.id);
    }
}
