package com.fundamentosSpringBoot.fundamentos.bean;

public class MyBeanImplementTwo implements MyBean{
    @Override
    public void print() {
        System.out.println("Hola desde mi implementación propia del bean 2" );
    }
}
