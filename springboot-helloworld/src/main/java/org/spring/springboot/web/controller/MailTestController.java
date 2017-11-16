package org.spring.springboot.web.controller;

import org.spring.springboot.web.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Peng.lv on 2017/11/16.
 */
@RestController
public class MailTestController {

    @Autowired
    private MailService mailService;
    private String to = "710584845@qq.com";

    @RequestMapping("/mailSend")
    public void sendSimpleMail() {
        mailService.sendSimpleMail(to, "主题：简单邮件", "测试邮件内容");
    }
}
