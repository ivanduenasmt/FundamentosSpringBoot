package com.fundamentosSpringBoot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplementTwo implements ComponentDependency {
    @Override
    public void saludar() {
        System.out.println("Hello world");
    }
}
