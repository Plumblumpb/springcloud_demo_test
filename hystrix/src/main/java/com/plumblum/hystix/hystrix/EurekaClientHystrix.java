package com.plumblum.hystix.hystrix;

import com.plumblum.hystix.feign.EurekaClientFeign;
import org.springframework.stereotype.Component;

/**
 * @Auther: cpb
 * @Date: 2019/1/11 14:30
 * @Description:
 */
@Component
public class EurekaClientHystrix implements EurekaClientFeign {

    @Override
    public String sayHiFromClientEureka(String name) {
        return "sorry:"+name;
    }
}
