package com.fundamentosSpringBoot.fundamentos.configuration;

import com.fundamentosSpringBoot.fundamentos.casesUse.GetUzer;
import com.fundamentosSpringBoot.fundamentos.casesUse.GetUzerImplement;
import com.fundamentosSpringBoot.fundamentos.service.UzerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUzer getUser(UzerService uzerService){
        return new GetUzerImplement(uzerService);
    }
}
