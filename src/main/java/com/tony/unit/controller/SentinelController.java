package com.tony.unit.controller;

import com.tony.unit.base.ResponseData;
import com.tony.unit.service.SentinelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br>
 * <b>功能：</b>sentinel测试<br>
 * <b>作者：</b>www.yamibuy.com<br>
 * <b>日期：</b> 2018/11/3 <br>
 * <b>版权所有：</b>版权所有(C) 2016，www.yamibuy.com<br>
 */
@RequestMapping("sentinel")
@RestController
public class SentinelController {

    @Autowired
    private SentinelService sentinelService;


    /**
     * 限流测试-类外部配置异常方法
     * @return
     */
    @GetMapping("/hello")
    public ResponseData getSentinels(){
        ResponseData data = new ResponseData();
        data.setData(sentinelService.sayHello());
        return data;
    }

    /**
     * 限流测试-类内部配置异常方法
     * @return
     */
    @GetMapping("/hello2")
    public ResponseData hello2(){
        ResponseData data = new ResponseData();
        data.setData(sentinelService.sayHello2(System.currentTimeMillis()));
        return data;
    }

}
