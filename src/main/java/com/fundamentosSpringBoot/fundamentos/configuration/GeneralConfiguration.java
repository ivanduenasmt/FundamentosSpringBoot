package com.fundamentosSpringBoot.fundamentos.configuration;

import com.fundamentosSpringBoot.fundamentos.Pojo.Pojo;
import com.fundamentosSpringBoot.fundamentos.bean.MyBeanProperties;
import com.fundamentosSpringBoot.fundamentos.bean.MyBeanPropertiesImplement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
}
