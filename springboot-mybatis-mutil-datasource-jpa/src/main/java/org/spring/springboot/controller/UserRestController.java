package org.spring.springboot.controller;

import com.alibaba.fastjson.JSON;
import org.spring.springboot.domain.master.User;
import org.spring.springboot.domain.mongodb.MailMsg;
import org.spring.springboot.service.UserService;
import org.spring.springboot.service.impl.MailServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户控制层
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailServerImpl mailServerImpl;

    /**
     * 根据用户名获取用户信息，包括从库的地址信息
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public User findByName(@RequestParam(value = "userName", required = true) String userName) {
        return userService.findByName(userName);
    }

    @RequestMapping(value="/mongodbInsert", method = RequestMethod.GET)
    public void mongodbInsert() {
        mailServerImpl.insertEmail();
    }

    @RequestMapping(value="/find/to", method = RequestMethod.GET)
    public String findMailByTo(HttpServletRequest request, String to) {
       // mailServerImpl.insertEmail();
        MailMsg msg = mailServerImpl.findByTo(to);
        if (msg == null){
            return "not found by to " + to;
        }
        return JSON.toJSONString(msg);
    }
}
