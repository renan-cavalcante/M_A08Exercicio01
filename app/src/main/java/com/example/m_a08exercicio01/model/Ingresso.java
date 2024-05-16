package com.example.m_a08exercicio01.model;

public class Ingresso {
    private String codigo;
    private float valor;

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    public float valorFinal(float taxa){

        return valor +(valor*taxa);
    }
}
