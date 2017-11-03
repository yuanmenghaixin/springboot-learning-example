package org.spring.springboot.web.controller;
import org.spring.springboot.web.model.Address;
import org.spring.springboot.web.model.User;
import org.spring.springboot.web.service.RedisCacheDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Peng.lv on 2017/11/3.
 */
@Controller
public class RedisCacheDemoController {

    @Autowired
    RedisCacheDemoService redisCacheDemoService;

    @RequestMapping("/test")
    @ResponseBody
    public String putCache(){
        redisCacheDemoService.findUser(1L,"wang","yunfei");
        redisCacheDemoService.findAddress(1L,"anhui","hefei");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return "ok";
    }
    @RequestMapping("/test2")
    @ResponseBody
    public String testCache(){
        User user = redisCacheDemoService.findUser(1L,"wang","yunfei");
        Address address = redisCacheDemoService.findAddress(1L,"anhui","hefei");
        System.out.println("我这里没执行查询");
        System.out.println("user:"+"/"+user.getFirstName()+"/"+user.getLastName());
        System.out.println("address:"+"/"+address.getProvince()+"/"+address.getCity());
        return "ok";
    }
}
