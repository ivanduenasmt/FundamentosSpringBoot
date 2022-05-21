package com.fundamentosSpringBoot.fundamentos.configuration;

import com.fundamentosSpringBoot.fundamentos.Pojo.Pojo;
import com.fundamentosSpringBoot.fundamentos.bean.MyBeanProperties;
import com.fundamentosSpringBoot.fundamentos.bean.MyBeanPropertiesImplement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(Pojo.class)
public class GeneralConfiguration {

    @Value("${value.nombre}")
    private String nombre;

    @Value("&{value.apellido}")
    private String apellido;

    @Value("&{value.random}")
    private String random;

    @Bean
    public MyBeanProperties function(){
        return new MyBeanPropertiesImplement(nombre,apellido);
    }

    //Asi obtengo el valor de mi connection.properties
    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url(jdbcUrl);
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
}
