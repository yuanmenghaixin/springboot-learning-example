package org.spring.springboot.domain.master;

import org.spring.springboot.domain.BaseEntity;
import org.spring.springboot.domain.cluster.City;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * 用户实体类
 *
 * Created by bysocket on 07/02/2017.
 */
@Entity(name="user")
public class User extends BaseEntity{

    /**
     * 城市名称
     */
    @Column(nullable = false)
    private String userName;

    /**
     * 描述
     */
    @Column
    private String description;

    @Transient
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
