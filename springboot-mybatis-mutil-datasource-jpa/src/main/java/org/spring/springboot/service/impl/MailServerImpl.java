package org.spring.springboot.service.impl;

import org.spring.springboot.domain.mongodb.MailMsg;
import org.spring.springboot.repository.mongodb.MailMsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Peng.lv on 2017/12/19.
 */
@Service
public class MailServerImpl {

    @Autowired
    private MailMsgRepository mailMsgRepository;

    public void insertEmail() {
        MailMsg mailMsg=new MailMsg();
        mailMsg.setId("id");
        mailMsg.setSendDt(new Date());
        mailMsg.setSubject("Springboot&mongodb");
        mailMsg.setText("moyo");
        mailMsg.setTo("strength");
        mailMsgRepository.insert(mailMsg);
    }

    public MailMsg findByTo(String to) {
        return mailMsgRepository.findByTo(to);
    }
}
