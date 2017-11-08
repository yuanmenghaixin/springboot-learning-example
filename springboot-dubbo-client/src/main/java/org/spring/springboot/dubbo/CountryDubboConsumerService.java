package org.spring.springboot.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import org.spring.springboot.domain.Country;
import org.springframework.stereotype.Component;

/**
 * 城市 Dubbo 服务消费者
 *
 * Created by bysocket on 28/02/2017.
 */
@Component
public class CountryDubboConsumerService {

    @Reference(version = "1.0.0")
    CountryDubboService countryDubboService;

    public void printCountry() {
        String countryName="中国";
        Country country = countryDubboService.findCountryByName(countryName);
        System.out.println(country.toString());
    }
}
