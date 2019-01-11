package com.plumblum.feignHystix.feign;

import com.plumblum.feignHystix.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: cpb
 * @Date: 2019/1/10 17:07
 * @Description:
 */
@FeignClient(value = "jpa",configuration = FeignConfig.class)
public interface JpaFeign {
    @RequestMapping("/test/test")
    public String test();
}
