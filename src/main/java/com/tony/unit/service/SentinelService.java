package com.tony.unit.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tony.unit.compnent.ExceptionUtil;
import org.springframework.stereotype.Service;

/**
 * <br>
 * <b>功能：</b>Sentinel限流测试<br>
 * <b>作者：</b>www.yamibuy.com<br>
 * <b>日期：</b> 2018/11/3 <br>
 * <b>版权所有：</b>版权所有(C) 2016，www.yamibuy.com<br>
 */
@Service
public class SentinelService {


    /**
     * 降级测试-外部配置降级方法
     * -------------
     * 降级后执行的方法名称为handleException, 由于该方法没有定义在本类中,所以需要配置blockHandlerClass属性指定该方法所在文件.
     * value值可以不与方法名保持一致,但为了便于在sentinel中管理, 建议保持一致.
     * handleException方法必须为public类型.
     * handleException方法签名必须与sayHello方法签名保持一致,另外handleException方法会多接受一个额外的参数BlockException ex
     * @see ExceptionUtil#handleException
     * {@link ExceptionUtil#handleException}
     *
     * @return
     */
    @SentinelResource(value = "sayHello", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    public String sayHello(){
        return "hello - original";
    }


    /**
     * 降级测试-内部配置降级方法
     * -------------
     * 使用当前类中定义的限流后触发逻辑不需要配置blockHandlerClass属性
     * @see #exceptionHandler
     * @param s
     * @return
     */
    @SentinelResource(value="sayHello2", blockHandler = "exceptionHandler")
    public String sayHello2(long s){
        return String.format("Hello at %d", s);
    }

    /**
     * 当前类下的定义的限流后触发逻辑
     * @param s
     * @param ex
     * @return
     */
    public String exceptionHandler(long s, BlockException ex) {
        ex.printStackTrace();
        return "Oops, error occurred at " + s;
    }


}
