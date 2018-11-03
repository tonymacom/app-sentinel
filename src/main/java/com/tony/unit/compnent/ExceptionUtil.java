package com.tony.unit.compnent;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * <br>
 * <b>功能：</b>自定义限流出发后的逻辑<br>
 * <b>作者：</b>www.yamibuy.com<br>
 * <b>日期：</b> 2018/11/3 <br>
 * <b>版权所有：</b>版权所有(C) 2016，www.yamibuy.com<br>
 */
public class ExceptionUtil {

    public static String handleException(BlockException ex) {
        String error = "Oops: " + ex.getClass().getCanonicalName();
        System.out.println(error);
        return error;
    }

}
