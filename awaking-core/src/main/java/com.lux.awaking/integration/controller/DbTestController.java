package com.lux.awaking.integration.controller;

import com.lux.awaking.integration.db.mapper.PwUserMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db")
public class DbTestController {
    @Resource
    private PwUserMapper userMapper;

    @GetMapping("/get")
    public String GetUserTest() {
        userMapper.getAllUsers();
        return "Success";
    }

}
