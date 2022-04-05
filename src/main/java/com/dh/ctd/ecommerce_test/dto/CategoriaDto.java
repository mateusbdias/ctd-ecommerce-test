package com.dh.ctd.ecommerce_test.dto;

public class CategoriaDto {

    private String nome;

    public CategoriaDto() {
    }

    public CategoriaDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
