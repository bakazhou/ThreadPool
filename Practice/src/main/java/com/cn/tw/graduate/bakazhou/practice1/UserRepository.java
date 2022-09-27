package com.cn.tw.graduate.bakazhou.practice1;

public class UserRepository {
    public User getUserById(Long id){
        try {
            //假设根据ID查询User需要耗时2s
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new User(id);
    }
}
