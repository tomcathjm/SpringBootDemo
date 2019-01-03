package com.hjm.service;

import com.hjm.bean.User;
import com.hjm.mapper.RestAPIUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestAPIUserService {

    @Autowired(required = false)
    RestAPIUserMapper raum;

    public List<User> getUsers(){
        return raum.getUsers();
    }

    public User getUserById(Integer id){
        return raum.getUserById(id);
    }

    public boolean addUser(User user) {
        return raum.addUser(user);
    }

    public boolean deleteUserById(Integer id) {
        return raum.deleteUserById(id);
    }

    public boolean updateUserById(User user) {
        return raum.updateUserById(user);
    }
}
