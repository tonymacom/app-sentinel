package com.tony.unit.init;

import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.tony.unit.compnent.CustomUrlBlockHandler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * <br>
 * <b>功能：</b>初始化组件<br>
 * <b>作者：</b>www.yamibuy.com<br>
 * <b>日期：</b> 2018/11/3 <br>
 * <b>版权所有：</b>版权所有(C) 2016，www.yamibuy.com<br>
 */
@Component
public class InitComponent {

    @PostConstruct
    public void init(){
        //添加自定义CustomBlockHandler方法
        WebCallbackManager.setUrlBlockHandler(new CustomUrlBlockHandler());
    }


}
