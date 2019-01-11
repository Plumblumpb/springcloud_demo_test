package com.plumblum.hystix.web;

import com.plumblum.hystix.feign.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: cpb
 * @Date: 2018/9/28 18:55
 * @Description:
 */
@RestController
public class HiController {
    @Autowired
    private EurekaClientFeign eurekaClientFeign;

    @GetMapping("/hi")
    public String sayHi(@RequestParam( defaultValue = "test",required = false)String name){
        return eurekaClientFeign.sayHiFromClientEureka(name);
    }
    
}