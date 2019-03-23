package com.plumblum.ribbonclient.web;

import com.plumblum.ribbonclient.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * author:plumblum
 * Date:2019/3/23
 * Time:17:07
 */
@RestController
public class RibbonController {
    @Autowired
    RibbonService ribbonService;

    @GetMapping("/hi")
    public String hi(@RequestParam(required = false,defaultValue = "test") String name){
        return ribbonService.hi(name);
    }

    @Autowired
//    获取负载均衡服务提供者的实例信息
    private LoadBalancerClient loadBalancer;

    @GetMapping("/testRibbon")
    public String  testRibbon() {
        ServiceInstance instance = loadBalancer.choose("eureka-client");
        //  URI uri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
        return instance.getHost()+":"+instance.getPort();
    }
}
