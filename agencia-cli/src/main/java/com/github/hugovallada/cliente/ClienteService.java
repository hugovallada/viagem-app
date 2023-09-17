package com.github.hugovallada.cliente;

import jakarta.ws.rs.*;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.time.temporal.ChronoUnit;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@RegisterRestClient(baseUri = "http://localhost:8180/clientes")
public interface ClienteService {

    @POST
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    String newCliente(Cliente cliente);

    @GET
    @Path("findById")
    @Timeout(unit = ChronoUnit.SECONDS, value = 3)
    @Fallback(fallbackMethod = "fallback")
    @CircuitBreaker(
            requestVolumeThreshold = 4,
            failureRatio = 0.5,
            delay = 6000L,
            successThreshold = 2)
    Cliente findById(@QueryParam("id") Long id);

    private Cliente fallback(Long id) {
        return Cliente.of(0, "");
    }
}
