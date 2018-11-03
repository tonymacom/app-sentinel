package com.tony.unit.compnent;

import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.system.SystemRule;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <br>
 * <b>功能：</b>
 * FlowRule的conver类型Bean定义,对应于spring.cloud.sentinel.datasource.converter配置的beean名称
 * spring.cloud.sentinel.datasource.converter=myParser
 *
 * @see FlowRule : sentinel限流规则
 * @see DegradeRule : sentinel降级规则
 * @see SystemRule : sentinel系统规则
 *
 * <br>
 * <b>作者：</b>www.yamibuy.com<br>
 * <b>日期：</b> 2018/11/3 <br>
 * <b>版权所有：</b>版权所有(C) 2016，www.yamibuy.com<br>
 */
@Component
public class MyParser implements Converter<String, List<FlowRule>> {

    @Override
    public List<FlowRule> convert(String source) {
        return JSON.parseObject(source,
                new TypeReference<List<FlowRule>>() {});
    }
}