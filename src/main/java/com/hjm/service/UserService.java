package com.hjm.service;

import com.hjm.bean.User;
import com.hjm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired(required = false)
    UserMapper userMapper;

    public List<User> getUsers(){
        return userMapper.getUsers();
    }

    public boolean register(User user){
        return userMapper.register(user);
    }

    public boolean delete(int id){
        return userMapper.delete(id);
    }

    public User queryUserById(int id){
        return userMapper.queryUserById(id);
    }

    public boolean updateUser(User user){
        return userMapper.updateUser(user);
    }

}
