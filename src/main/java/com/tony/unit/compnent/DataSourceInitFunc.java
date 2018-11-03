package com.tony.unit.compnent;

import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.cloud.alibaba.sentinel.datasource.annotation.SentinelDataSource;
import org.springframework.context.annotation.Configuration;

/**
 * <br>
 * <b>功能：</b>
 *  初始化限流/降级/系统规则 函数类
 * <br>
 * <b>作者：</b>www.yamibuy.com<br>
 * <b>日期：</b> 2018/11/3 <br>
 * <b>版权所有：</b>版权所有(C) 2016，www.yamibuy.com<br>
 */
@Configuration
public class DataSourceInitFunc implements InitFunc {

    @SentinelDataSource("spring.cloud.sentinel.datasource")
    private ReadableDataSource dataSource;

    @Override
    public void init() throws Exception {
        FlowRuleManager.register2Property(dataSource.getProperty());
    }
}
