package com.plumblum.hystix.hystrix;

import com.netflix.hystrix.*;

/**
 * @author cpb
 * @version 1.0
 * @date 2019/12/9 18:17
 */
public class MyHystrix extends HystrixCommand<Integer> {

    /**
     * 重写构造方法
     * @param setter
     */
    protected MyHystrix(Setter setter) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("mytest"))//设置分组名称
                .andCommandKey(HystrixCommandKey.Factory.asKey("test"))//设置命令名称
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerRequestVolumeThreshold(10)//至少有10个请求，熔断器才进行错误率的计算
                        .withCircuitBreakerSleepWindowInMilliseconds(5000)//熔断器中断请求5秒后会进入半打开状态,放部分流量过去重试
                        .withCircuitBreakerErrorThresholdPercentage(50)//错误率达到50开启熔断保护
                        .withExecutionTimeoutEnabled(true))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties
                        .Setter().withCoreSize(10)));
    }

    @Override
    /**
     * 异常返回结果
     */
    protected Integer getFallback() {
        return -1;
    }
    @Override
    /**
     * 设置正常返回值
     */
    protected Integer run() throws Exception {
        return 1;
    }
}
