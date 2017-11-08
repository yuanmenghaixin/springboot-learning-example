package org.spring.springboot.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.spring.springboot.domain.Country;
import org.spring.springboot.dubbo.CountryDubboService;

/**
 * 城市业务 Dubbo 服务层实现层
 *
 * Created by bysocket on 28/02/2017.
 */
// 注册为 Dubbo 服务
@Service(version = "1.0.0")
public class CountryDubboServiceImpl implements CountryDubboService {

    @Override
    public Country findCountryByName(String countryName) {
        return new Country(8L,"中国","是个伟大的民族！");
    }
}
