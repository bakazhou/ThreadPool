package com.cn.tw.graduate.bakazhou.practice1;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        //获取开始时间
        long startTime = System.currentTimeMillis();
        // 假设要查10个用户的信息，用一条线程去查就需要15s
        for (int i = 0; i < 15; i++) {
            User user = userService.getUser((long) i);
            System.out.println("user id:"+user.getId());
        }

        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("单线程总耗时:" + (endTime - startTime) / 1000 + "s");
    }
}
