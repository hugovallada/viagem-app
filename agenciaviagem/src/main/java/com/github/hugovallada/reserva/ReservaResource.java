package com.github.hugovallada.reserva;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.Response.Status.CREATED;

import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/reservas")
public class ReservaResource {

    @GET
    @Produces(APPLICATION_JSON)
    public List<Reserva> get() {
        return Reserva.listAll();
    }

    @POST
    @Produces(APPLICATION_JSON)
    @Transactional
    @Consumes(APPLICATION_JSON)
    public Response newReserva(Reserva reserva) {
        reserva.id = null;
        reserva.persist();
        return Response
                .status(CREATED)
                .entity(reserva)
                .build();
    }

}
