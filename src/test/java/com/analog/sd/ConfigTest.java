package com.analog.sd;

import com.analog.sd.redis.config.ValueConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="file:src/test/java/test.properties")
public class ConfigTest {

    @Autowired
    private ValueConfig valueConfig;

    @Test
    public void t() {
        System.out.println("name : " + valueConfig.getName() + ",code : " + valueConfig.getCode());
    }


}
