package org.spring.springboot.repository.master;

import org.spring.springboot.domain.master.User;
import org.spring.springboot.repository.BaseRepository;

/**
 * Created by Peng.lv on 2017/12/13.
 */
public interface UserRepository extends BaseRepository<User,Long> {
    User findByUserName(String userName);
}
