package com.github.hugovallada.reserva;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@RegisterRestClient(baseUri = "http://localhost:8222/reservas")
public interface ReservaService {

    @POST
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    Response newReserva(Reserva reserva);

}
