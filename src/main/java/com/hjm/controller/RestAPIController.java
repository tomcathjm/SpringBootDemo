package com.hjm.controller;

import com.hjm.bean.User;
import com.hjm.service.RestAPIUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class RestAPIController {

    @Autowired
    RestAPIUserService raus;

    // 测试传参以及jUnit
//    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
//    public List<User> getUsers(@PathVariable Integer id , Integer code){
//        System.err.println("id："+id);
//        System.out.println();// 请求路径中携带的参数  2
//        System.out.println("code："+code); // 请求中携带的参数     1
//        return raus.getUsers();
//    }

    //Get   获取用户列表
    @GetMapping("/")
    public List<User> getUsers(){

        return raus.getUsers();
    }

    //Get   根据 id 获取一个用户
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){

        User user = raus.getUserById(id);

        return user;
    }
    //Post  新增一个用户
    @PostMapping("/")
    public String addUser(User user){

        return raus.addUser(user) ? "success" : "fail";
    }
    //Delete根据 id 删除用户
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Integer id){

        return raus.deleteUserById(id) ? "success" : "fail";
    }
    //Put   根据 id 修改用户
    @PutMapping("/{id}")
    public String updateUserById(@PathVariable Integer id , User user){

        user.setId(id);

        return raus.updateUserById(user) ? "success" : "fail";
    }


}
