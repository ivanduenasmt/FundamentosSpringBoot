package com.fundamentosSpringBoot.fundamentos.configuration;

import com.fundamentosSpringBoot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBeanImplementTwo();
    }

    @Bean
    public MyOperation myOperation(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency myBeanWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }

    @Bean
    public PersonaInterface personaInterface(){
        return new Persona();
    }

    @Bean
    public CarreraF1Interface carreraF1Interface(){
        return new CarreraF1();
    }

    @Bean
    public CarreraF1Interface carreraF1InterfaceConParámetros(){return new CarreraF1(57,"Lewis Hamilton","2021/12/12"); }

}
