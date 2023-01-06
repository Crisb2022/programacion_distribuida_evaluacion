package com.distribuida.servicios;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.time.LocalDateTime;

@ApplicationScoped
@Path(value="/")
public class ServiciosHolaMundoImpl implements ServicioHolaMundo {
    @GET
    @Path("/hola")
    public String hola(){
        return "Hola "+ LocalDateTime.now();
    }
}
