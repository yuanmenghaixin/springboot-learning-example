package org.spring.springboot.config.ds;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * jpa配置
 * Created by Peng.lv on 2017/12/13.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"org.spring.springboot.repository.master"}, entityManagerFactoryRef = "masterSpringEntityManagerFactory",
        transactionManagerRef = "masterSpringTransactionManager")
public class SpringMasterJpaConfig {

    @Autowired
    private JpaProperties jpaProperties;

    @Value("${master.datasource.url}")
    private String url;

    @Value("${master.datasource.username}")
    private String user;

    @Value("${master.datasource.password}")
    private String password;

    @Value("${master.datasource.driverClassName}")
    private String driverClass;
    @Bean(name = "masterJpaDataSource")
    public DataSource dataSource() {
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName(driverClass);
        source.setUrl(url);
        source.setUsername(user);
        source.setPassword(password);
        return source;
    }

    @Bean(name = "masterEntityManager")
    @Primary
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return masterSpringEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Bean(name = "masterSpringEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean masterSpringEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource())
                         .properties(getVendorProperties())
                         .packages("org.spring.springboot.domain.master") //设置实体类所在位置
                         .persistenceUnit("primaryPersistenceUnit")
                         .build();
       /* LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factory.setPackagesToScan(new String[]{"org.spring.springboot.domain.master"});
        factory.setJpaProperties(getVendorProperties());
        factory.afterPropertiesSet();
        return factory;*/
    }

    @Bean(name = "masterSpringTransactionManager")
    @Primary
    public PlatformTransactionManager masterSpringTransactionManager(EntityManagerFactoryBuilder builder) {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(masterSpringEntityManagerFactory(builder).getObject());
        return manager;
    }

    private Map<String, String> getVendorProperties() {
         return jpaProperties.getHibernateProperties(dataSource());
     }
}
