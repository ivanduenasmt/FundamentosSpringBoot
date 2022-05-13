package com.fundamentosSpringBoot.fundamentos.bean;

import java.util.Date;

public class CarreraF1 implements CarreraF1Interface {
    private int numeroVueltas;
    private String ganador;
    private String fecha;

    public CarreraF1() {
    }

    public CarreraF1(int numeroVueltas, String ganador, String fecha) {
        this.numeroVueltas = numeroVueltas;
        this.ganador = ganador;
        this.fecha = fecha;
    }

    public int getNumeroVueltas() {
        return numeroVueltas;
    }

    public void setNumeroVueltas(int numeroVueltas) {
        this.numeroVueltas = numeroVueltas;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public void mostrarNombreCircuito(String circuito, String pais) {
        System.out.println("La carrera se corrio en "+circuito+" en "+pais);
    }

    @Override
    public void mostrarNombreCircuitoConTodosLosDatos(String ganador, int numeroVueltas, String fecha) {
        setGanador(getGanador());
        numeroVueltas = getNumeroVueltas();
        fecha = getFecha();
        System.out.println("El ganador fue "+ganador+" en vueltas circuito : "+numeroVueltas+ " el dia "+ fecha);
    }


}
