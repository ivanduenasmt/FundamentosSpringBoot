package com.fundamentosSpringBoot.fundamentos.bean;

import java.util.Date;

public class Persona implements PersonaInterface{
    private String nombre;
    private int edad;
    private String profesion;
    private Date nacimiento;

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public void saludar(String nombre, int edad) {
        System.out.println("Hola "+nombre+" tienes "+edad+" años");
    }
}
