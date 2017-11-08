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
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.242.128:6379");
        RedissonClient redisson = Redisson.create(config);
        System.out.print("成功连接Redis Server"+"\t"+"连接"+"192.168.242.128"+":"+"6379"+"服务器");
        return "Hello,World!";
    }
}
