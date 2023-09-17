package com.github.hugovallada.cliente;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/clientes-cli")
public class ClienteResource {

    ClienteService clienteService;

    public ClienteResource(@RestClient ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GET
    @Path("/findById")
    public Cliente findById(@QueryParam("id") Long id) {
        return clienteService.findById(id);
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Response newCliente() {
        var cliente = Cliente.of(1, "Hugo");
        var output = clienteService.newCliente(cliente);
        return Response
                .status(Response.Status.CREATED)
                .entity(output)
                .build();
    }

}
