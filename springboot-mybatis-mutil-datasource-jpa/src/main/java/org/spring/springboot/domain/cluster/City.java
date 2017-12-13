package org.spring.springboot.domain.cluster;

import org.spring.springboot.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 城市实体类
 *
 * Created by bysocket on 07/02/2017.
 */
@Entity(name="city")
public class City extends BaseEntity{

    /**
     * 省份编号
     */
    @Column(nullable = false)
    private Long provinceId;

    /**
     * 城市名称
     */
    @Column(nullable = false)
    private String cityName;

    /**
     * 描述
     */
    @Column
    private String description;

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
