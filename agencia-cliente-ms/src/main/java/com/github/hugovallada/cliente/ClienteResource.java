package com.github.hugovallada.cliente;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/clientes")
public class ClienteResource {

    @GET
    @Produces(APPLICATION_JSON)
    public List<Cliente> get() {
        return Cliente.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Cliente findById(@PathParam("id") long id) {
        return Cliente.findById(id);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteById(@PathParam("id") long id) {
        Cliente.deleteById(id);
    }

    @POST
    @Transactional
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response newCliente(@Valid Cliente cliente) {
        cliente.id = null;
        cliente.persist();
        return Response
                .status(Status.CREATED)
                .entity(cliente)
                .build();
    }

}
