package com.fundamentosSpringBoot.fundamentos.casesUse;

import com.fundamentosSpringBoot.fundamentos.entity.Uzer;
import com.fundamentosSpringBoot.fundamentos.service.UzerService;

import org.springframework.stereotype.Component;

@Component
public class UpdateUzer {

    private UzerService uzerService;

    public UpdateUzer(UzerService uzerService) {
        this.uzerService = uzerService;
    }

    public Uzer update(Uzer newUzer, Long id) {
        return uzerService.update(newUzer, id);
    }
}
