package com.cn.tw.graduate.bakazhou.practice1;

public class UserService {
    UserRepository repository = new UserRepository();
    public User getUser(Long id){
        return repository.getUserById(id);
    }
}
