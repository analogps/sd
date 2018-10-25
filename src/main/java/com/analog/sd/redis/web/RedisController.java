package com.analog.sd.redis.web;

import com.analog.sd.redis.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisDao redisDao;

    @GetMapping("/redis/get")
    public String get() {
        return redisDao.get("hello");
    }

}
