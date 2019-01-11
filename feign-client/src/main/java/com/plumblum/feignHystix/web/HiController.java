package com.plumblum.feignHystix.web;


import com.plumblum.feignHystix.feign.EurekaClientFeign;
import com.plumblum.feignHystix.feign.JpaFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @Autowired
    private JpaFeign jpaFeign;
    @GetMapping("/hi")
    public String sayHi(@RequestParam( defaultValue = "test",required = false)String name){
        return eurekaClientFeign.sayHiFromClientEureka(name);
    }

    @RequestMapping("/test")
    public String test(){
        return jpaFeign.test();
    }

}