package com.plumblum.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @Auther: cpb
 * @Date: 2019/1/11 15:20
 * @Description:
 */
@Component
public class MyFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);
    //定义filter的类型
    @Override
    public String filterType() {
        return PRE_TYPE;
    }
    //定义filter的执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }
    //定义是否需要执行
    @Override
    public boolean shouldFilter() {
        return true;
    }
    //需要执行的具体操作
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            try {
//                ctx.getResponse().getWriter().write("token is empty");
//            }catch (Exception e){}

            return null;
        }
        log.info("ok");
        return null;
    }
}
