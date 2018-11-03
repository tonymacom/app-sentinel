package com.tony.unit.compnent;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <br>
 * <b>功能：</b>自定义URL阻塞的处理流程, 配置了url的限流规则后走这里<br>
 * <b>作者：</b>www.yamibuy.com<br>
 * <b>日期：</b> 2018/11/3 <br>
 * <b>版权所有：</b>版权所有(C) 2016，www.yamibuy.com<br>
 */
public class CustomUrlBlockHandler implements UrlBlockHandler {

    @Override
    public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws IOException {

        //如果不配置, 直接返回 "Blocked by Sentinel (flow limiting)"
        System.out.println("-------------invoked the customUrlBlockHandler which writed by tony---------------------");
        httpServletResponse.sendRedirect("/error");
    }
}
