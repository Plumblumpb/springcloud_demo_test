package com.plumblum.feignHystix.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @Auther: cpb
 * @Date: 2018/9/28 18:48
 * @Description:
 */
@Configuration
public class FeignConfig {
    @Bean
//    当远程调用失败会进行重试
    public Retryer feignRetryer(){
        return new Retryer.Default(100,SECONDS.toMillis(1),5);
    }
}
