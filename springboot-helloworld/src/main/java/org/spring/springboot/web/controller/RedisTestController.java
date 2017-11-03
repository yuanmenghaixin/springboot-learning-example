package org.spring.springboot.web.controller;

import org.spring.springboot.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Peng.lv on 2017/11/3.
 */
@RestController
@RequestMapping(value="/redis")
public class RedisTestController{
    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})
    public String redisTest(){
        StringBuffer sb = new StringBuffer();
        redisUtil.set("str", "str");
        sb.append("str=").append(redisUtil.get("str").toString()).append(",");
        redisUtil.hmSet("hmset","key","val");
        sb.append("hmset=").append(redisUtil.hmGet("hmset","key")).append(",");
        redisUtil.lPush("list","val");
        sb.append("list=").append(redisUtil.lRange("list",0,1).toString()).append(",");
        redisUtil.add("set","val");
        sb.append("set=").append(redisUtil.setMembers("set").toString()).append(",");
        redisUtil.zAdd("zset","val1",1);
        redisUtil.zAdd("zset","val2",2);
        sb.append("zset=").append(redisUtil.rangeByScore("zset",1,2)).append(",");
        return sb.toString();
    }
}