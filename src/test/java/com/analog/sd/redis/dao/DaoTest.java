package com.analog.sd.redis.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="file:src/test/java/test.properties")
public class DaoTest {

    @Autowired
    private RedisDao redisDao;

    @Test
    public void set() {
        redisDao.set("hello", "hitest");
    }

    @Test
    public void get() {
        redisDao.get("hello");
        System.out.println(redisDao.get("hello"));
    }

}
