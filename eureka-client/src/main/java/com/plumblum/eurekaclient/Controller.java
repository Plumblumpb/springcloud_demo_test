package com.plumblum.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: cpb
 * @Date: 2018/9/28 17:13
 * @Description:
 */
@RestController
public class Controller {

    @Value("${server.port}")
    String port;

    @GetMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }


}
