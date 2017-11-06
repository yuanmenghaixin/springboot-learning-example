package org.spring.springboot.web.controller;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot HelloWorld 案例
 *
 * Created by bysocket on 16/4/26.
 */
@RestController
public class HelloWorldController {

//访问地址http://localhost:8080/
    @RequestMapping("/")
    public String sayHello() {
        Config config=new Config();
        config.useSingleServer().setAddress("10.200.145.152"+":"+"6379");
        config.useSingleServer().setPassword("redismoyo");
        RedissonClient redisson=Redisson.create(config);
        System.out.print("成功连接Redis Server"+"\t"+"连接"+"10.200.145.152"+":"+"6379"+"服务器");
        return "Hello,World!";
    }
}
