package com.analog.sd.redis.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("file:./src/main/config/sd.yml")
public class ValueConfig {

    @Value("${code}")
    private String code;

    @Value("${name}")
    private String name;


}
