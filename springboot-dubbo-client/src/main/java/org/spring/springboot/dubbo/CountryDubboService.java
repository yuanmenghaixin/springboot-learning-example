package org.spring.springboot.dubbo;

import org.spring.springboot.domain.Country;

/**
 * 国家业务 Dubbo 服务层
 *
 * Created by bysocket on 28/02/2017.
 */
public interface CountryDubboService {

    /**
     * 根据国家名称，查询城市信息
     * @param countryName
     */
    Country findCountryByName(String countryName);
}
