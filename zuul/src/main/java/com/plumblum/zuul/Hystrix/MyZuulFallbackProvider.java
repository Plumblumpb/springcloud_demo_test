package com.plumblum.zuul.Hystrix;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * @Auther: cpb
 * @Date: 2019/1/11 15:35
 * @Description:
 */
//路由熔断，降级处理
//实现方式：一个指明熔断拦截哪个服务，一个定制返回内容。
//只支持服务级别的熔断，不支持某个url的熔断。
@Component
public class MyZuulFallbackProvider implements ZuulFallbackProvider {

    //定义哪个route的熔断器
    @Override
    public String getRoute() {
        return null;
    }
    //发生熔断时，提供怎么样的返回值
    @Override
    public ClientHttpResponse fallbackResponse() {
        return null;
    }
}
