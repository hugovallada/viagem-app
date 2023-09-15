package com.github.hugovallada.cliente;


public class Cliente {
    private long id;
    private String nome;
    
    private Cliente(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static Cliente of(long id, String nome) {
        return new Cliente(id, nome);
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
