package com.pangu.springContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @author:liuzhaolu
 * @createTime: 2020-01-10 17:38
 * @desc:
 */
@Configuration
public class Config{
    private String name = "hello";
    private String env = "test";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    @Bean
    public Config configDemoBean() {
        return new Config();
    }
}
