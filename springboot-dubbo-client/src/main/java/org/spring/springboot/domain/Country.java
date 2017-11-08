package org.spring.springboot.domain;

import java.io.Serializable;

/**
 * 城市实体类
 *
 * Created by bysocket on 07/02/2017.
 */
public class Country implements Serializable {
    private static final long serialVersionUID = -1L;
    /**
     * 国家编号
     */
    private Long id;

    /**
     * 国家名称
     */
    private String countryName;

    /**
     * 描述
     */
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
