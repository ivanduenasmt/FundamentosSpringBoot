package com.fundamentosSpringBoot.fundamentos.casesUse;

import com.fundamentosSpringBoot.fundamentos.entity.Uzer;
import com.fundamentosSpringBoot.fundamentos.service.UzerService;
import org.springframework.stereotype.Component;

@Component
public class CreateUzer {
    private UzerService uzerService;

    public CreateUzer(UzerService uzerService) {
        this.uzerService = uzerService;
    }

    public Uzer save(Uzer newUzer) {
        return  uzerService.save(newUzer);
    }
}
