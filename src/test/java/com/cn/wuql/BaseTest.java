package com.cn.wuql;

import com.cn.wuql.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@TestPropertySource("/application.properties")
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class BaseTest {

    @Configuration
    @ComponentScan(basePackages = {"com.cn"}, excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class))
    static class ComponentScanConfig {

    }


    @Test
    public void contextLoads() {
    }

}