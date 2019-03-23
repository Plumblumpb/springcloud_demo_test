package com.plumblum.ribbonclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IDEA
 * author:plumblum
 * Date:2019/3/23
 * Time:17:05
 */
@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;

    public String hi(String name) {
//        不需要硬编码（指定ip），只需要使用spring.application.name 即可。
        return restTemplate.getForObject("http://eureka-client/hi?name="+name,String.class);
    }
}
