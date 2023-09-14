package com.github.hugovallada.cliente;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Cliente extends PanacheEntity {
    public String nome;
}
