package org.spring.springboot.web.service;
import org.spring.springboot.utils.RedisUtil;
import org.spring.springboot.web.model.Address;
import org.spring.springboot.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
/**
 * Created by Peng.lv on 2017/11/3.
 */
@Service
public class RedisCacheDemoService {
    @Autowired
    private RedisUtil redisUtil;
    @Cacheable(value = "usercache",keyGenerator = "wiselyKeyGenerator")
    public User findUser(Long id, String firstName, String lastName){
        System.out.println("无缓存的时候调用这里");
        redisUtil.save("string","字符串的简单实现");
        return new User(id,firstName,lastName);
    }
    @Cacheable(value = "addresscache",keyGenerator = "wiselyKeyGenerator")
    public Address findAddress(Long id, String province, String city){
        System.out.println("无缓存的时候调用这里");
        return new Address(id,province,city);
    }
}
