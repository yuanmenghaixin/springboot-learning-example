package org.spring.springboot.domain.mongodb;
import org.springframework.data.annotation.Id;

import java.util.Date;
/**
 * Created by Peng.lv on 2017/12/19.
 */
public class MailMsg {
    @Id
    private String id;

    private String to;

    private String subject;

    private String text;

    private Date sendDt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getSendDt() {
        return sendDt;
    }

    public void setSendDt(Date sendDt) {
        this.sendDt = sendDt;
    }
}
