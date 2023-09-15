package com.github.hugovallada.cliente;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

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
