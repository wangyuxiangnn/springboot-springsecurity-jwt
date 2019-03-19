package com.kyle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wangyuxiang
 * @Date 2018-11-28 14:14
 * @Version 1.0
 **/
@Configuration
public class RelyAboutBeanConfig {

    @Bean(name = "snowflakeIdWorker")
    public SnowflakeIdWorker getSnowflakeIdWorker() {
        return new SnowflakeIdWorker(1, 2);
    }

    @Bean(name = "mPasswordEncoder")
    public MPasswordEncoder getMPasswordEncoder(){
        return new MPasswordEncoder();
    }
}
