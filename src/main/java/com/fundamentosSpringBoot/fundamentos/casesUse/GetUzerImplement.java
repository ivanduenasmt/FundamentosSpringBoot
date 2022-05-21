package com.fundamentosSpringBoot.fundamentos.casesUse;

import com.fundamentosSpringBoot.fundamentos.entity.Uzer;
import com.fundamentosSpringBoot.fundamentos.service.UzerService;

import java.util.List;

public class GetUzerImplement implements GetUzer{
    private UzerService uzerService;

    public GetUzerImplement(UzerService uzerService) {
        this.uzerService = uzerService;
    }

    @Override
    public List<Uzer> getAll() {
        return uzerService.getAllUzers();
    }
}
