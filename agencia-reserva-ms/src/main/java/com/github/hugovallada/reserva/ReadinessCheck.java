package com.github.hugovallada.reserva;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        if (Reserva.listAll() == null) {
            return HealthCheckResponse.down("I'm not ready!");
        }
        return HealthCheckResponse.up("I'm ready!");
    }
}
