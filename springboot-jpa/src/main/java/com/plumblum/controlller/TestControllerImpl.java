package com.plumblum.controlller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: cpb
 * @Date: 2019/1/10 16:42
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestControllerImpl implements TestControlller {
    @Override
    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
