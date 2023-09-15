package com.github.hugovallada.cliente;

import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@RegisterRestClient(baseUri = "http://localhost:8180/clientes")
public interface ClienteService {

    @POST
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    String newCliente(Cliente cliente);

    @GET
    @Path("findById")
    Cliente findById(@QueryParam("id") Long id);
}
