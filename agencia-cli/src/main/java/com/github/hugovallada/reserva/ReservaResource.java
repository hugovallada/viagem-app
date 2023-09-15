package com.github.hugovallada.reserva;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import com.github.hugovallada.cliente.Cliente;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/reservas-cli")
public class ReservaResource {

    private ReservaService reservaService;

    public ReservaResource(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Response newReserva() {
        var cliente = Cliente.of(1, "Hugo");
        var reserva = Reserva.of(cliente);
        var resp = reservaService.newReserva(reserva);
        return Response
                .status(Response.Status.CREATED)
                .entity(resp)
                .build();
    }

}
