package com.vmware.firstappdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.vmware.firstappdemo.model.Users;
import com.vmware.firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/hello")
    public String hello(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        return jsonObject.toJSONString();
    }
}
