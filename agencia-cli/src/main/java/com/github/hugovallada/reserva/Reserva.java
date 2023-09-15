package com.github.hugovallada.reserva;

import com.github.hugovallada.cliente.Cliente;

public class Reserva {

    private Cliente cliente;

    private Reserva(Cliente cliente) {
        this.cliente = cliente;
    }

    public static Reserva of(Cliente cliente) {
        return new Reserva(cliente);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
