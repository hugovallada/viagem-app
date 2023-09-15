package com.github.hugovallada.reserva;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Reserva extends PanacheEntity {

    public Long idCliente;

}
