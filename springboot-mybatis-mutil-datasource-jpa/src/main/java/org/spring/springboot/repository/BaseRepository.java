package org.spring.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by Peng.lv on 2017/12/13.
 */
@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable> extends CrudRepository<T, ID> {

}