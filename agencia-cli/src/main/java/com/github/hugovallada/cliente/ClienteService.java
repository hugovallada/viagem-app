package com.github.hugovallada.cliente;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@RegisterRestClient(baseUri = "http://localhost:8080/clientes")
public interface ClienteService {

    @POST
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Response newCliente(Cliente cliente);

}
