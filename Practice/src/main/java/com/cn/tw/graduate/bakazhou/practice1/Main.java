package com.cn.tw.graduate.bakazhou.practice1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        //获取开始时间
        long startTime = System.currentTimeMillis();
        // 假设要查10个用户的信息，用一条线程去查就需要30s
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            users.add(userService.getUser((long) i));
        }
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("单线程总耗时:" + (endTime - startTime) / 1000 + "s");
    }
}
