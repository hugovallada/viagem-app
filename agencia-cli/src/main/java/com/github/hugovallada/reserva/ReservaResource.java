package com.github.hugovallada.reserva;

import com.github.hugovallada.cliente.ClienteService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/reservas-cli")
public class ReservaResource {

    private final ReservaService reservaService;

    private final ClienteService clienteService;

    public ReservaResource(@RestClient ReservaService reservaService, @RestClient ClienteService clienteService) {
        this.reservaService = reservaService;
        this.clienteService = clienteService;
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Response newReserva(@PathParam("id") Long id) {
        var cliente = clienteService.findById(id);
        var reserva = Reserva.of(cliente);
        var resp = reservaService.newReserva(reserva);
        return Response
                .status(Response.Status.CREATED)
                .entity(resp)
                .build();
    }

}
