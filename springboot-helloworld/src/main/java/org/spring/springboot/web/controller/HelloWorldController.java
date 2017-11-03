package org.spring.springboot.web.controller;

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
        return "Hello,World!";
    }
}
