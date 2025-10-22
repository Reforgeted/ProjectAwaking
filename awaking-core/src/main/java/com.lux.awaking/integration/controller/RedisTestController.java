package com.lux.awaking.integration.controller;

import com.lux.awaking.integration.controller.vo.AwakingRedisVo;
import com.lux.awaking.integration.redis.RedisUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/redis")
public class RedisTestController {
    @Resource
    private RedisUtils redisUtils;

    @PostMapping("/put")
    public String PutTest(@RequestBody AwakingRedisVo redisVo) {
        redisUtils.set(redisVo.getKey(), redisVo.getValue());
        if (!Objects.isNull(redisUtils.get(redisVo.getKey()))) {
            return "Success";
        }
        return "Failed";
    }
}
