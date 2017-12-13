package org.spring.springboot.service.impl;

import org.spring.springboot.dao.cluster.CityDao;
import org.spring.springboot.dao.master.UserDao;
import org.spring.springboot.domain.cluster.City;
import org.spring.springboot.domain.master.User;
import org.spring.springboot.repository.cluster.CityRepository;
import org.spring.springboot.repository.master.UserRepository;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现层
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao; // 主数据源

    @Autowired
    private CityDao cityDao; // 从数据源

    @Autowired
    CityRepository cityRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByName(String userName) {
        User user = userDao.findByName(userName);
        City city = cityDao.findByName("温岭市");
        user = userRepository.findByUserName(userName);
        city = cityRepository.findByCityName("温岭市");

        user.setCity(city);
        return user;
    }
}
