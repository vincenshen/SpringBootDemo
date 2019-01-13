package com.vmware.firstappdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.vmware.firstappdemo.domain.User;
import com.vmware.firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam String name){
        User user = new User();
        user.setName(name);
        if(userRepository.save(user)){
            System.out.printf("用户对象: %s 保存成功！\n", user);
        }
        return user;
    }

    @GetMapping("/person/all")
    public Collection<User> allUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/hello")
    public String hello(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        return jsonObject.toJSONString();
    }
}
