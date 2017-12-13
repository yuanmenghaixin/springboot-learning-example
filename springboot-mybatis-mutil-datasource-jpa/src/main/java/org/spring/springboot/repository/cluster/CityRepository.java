package org.spring.springboot.repository.cluster;

import org.spring.springboot.domain.cluster.City;
import org.spring.springboot.repository.BaseRepository;

/**
 * Created by Peng.lv on 2017/12/13.
 */
public interface CityRepository extends BaseRepository<City,Long> {
    City findByCityName(String cityName);
}
