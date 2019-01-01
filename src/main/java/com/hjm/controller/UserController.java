package com.hjm.controller;

import com.hjm.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hjm.service.UserService;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/homepage")
    public String homePage(Model model){

        List<User> users = userService.getUsers();
        model.addAttribute("users",users);
        model.addAttribute("title","首页");

        return "/homepage";

    }

    @RequestMapping("/register")
    public String register(User user){

        if (user.getPassword() == null || user.getUsername() == null){
            return "/register";
        }else {
            boolean isSuccessful = userService.register(user);

            if (isSuccessful) {
                return "forward:/homepage"; // Forward ---> homepage
            } else {
                return "/register";
            }
        }
    }

    @RequestMapping("/delete")
    public String delete(Model model , Integer id){

        boolean isSuccessful = userService.delete(id);

        if (!isSuccessful){

            model.addAttribute("errorMsg","Delete Failed");

        }
        return "forward:/homepage";

    }

    @RequestMapping("/update")
    public String update(Model model , User user){

        if (user.getUsername() != null && user.getPassword() != null){    // handler update

            boolean isSuccessful = userService.updateUser(user);

            if (isSuccessful){

                return "forward:/homepage";

            }else{  // Failed--->update.html，提示errorMsg

                return showUpdateHTML(model , user.getId() , "Update Failed");
            }

        }else{  // show update.html
            return showUpdateHTML(model , user.getId() , "");

        }
    }

    // return update.html and show errorMsg
    public String showUpdateHTML(Model model,int id , String errorMsg){

        User u = userService.queryUserById(id);
        model.addAttribute("user" , u);
        model.addAttribute("errorMsg" , errorMsg);

        return "/update";
    }

    @RequestMapping("/getUsers")
    @ResponseBody
    public List<User> getUsers(){

        List<User> users = userService.getUsers();

        return users;
    }

}
