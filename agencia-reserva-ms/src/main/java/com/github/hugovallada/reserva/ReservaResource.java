package com.github.hugovallada.reserva;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.Response.Status.CREATED;

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
