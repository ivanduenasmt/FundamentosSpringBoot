package com.fundamentosSpringBoot.fundamentos.casesUse;

import com.fundamentosSpringBoot.fundamentos.service.UzerService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUzer {

    private UzerService uzerService;

    public DeleteUzer(UzerService uzerService) {
        this.uzerService = uzerService;
    }

    public void remove(Long id) {
        uzerService.delete(id);
    }
}
