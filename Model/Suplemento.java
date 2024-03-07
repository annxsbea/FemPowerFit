package br.com.fempowerfit.Model;

import java.util.Random;

public record Suplemento(Long id, String nome, String image) {

    public Suplemento(Long id, String nome, String image) {
        var chave = (id != null) ? id : Math.abs( new Random().nextLong() );
        this.id = chave;
        this.nome = nome;
        this.image = image;
    }
}