package org.spring.springboot.repository.mongodb;

import org.spring.springboot.domain.mongodb.MailMsg;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Peng.lv on 2017/12/19.
 */
public interface  MailMsgRepository extends MongoRepository<MailMsg, Long> {

    MailMsg findByTo(String to);
}
