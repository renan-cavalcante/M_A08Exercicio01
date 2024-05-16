package com.example.m_a08exercicio01.model;

public class IngressoVip extends Ingresso{
    private String funcao;

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    @Override
    public float valorFinal(float taxa) {
        return (super.valorFinal(taxa))*1.18f;
    }
}
