package com.distribuida.config;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

@ApplicationScoped // Permite que sea un componente CDI
public class DBconfig {
    // Opcion 2 solamente para CDI, es practico poner un valor por defecto
    @Inject
    @ConfigProperty(name="db.user")
    String dbUser;

    @Inject
    @ConfigProperty(name="db.password")
    String dbPassword;

    @Inject
    @ConfigProperty(name="db.url")
    String dbURL;

    Jdbi conexion = null;
    @PostConstruct
    public void init(){
    }

    public void test() {

    }

    @ApplicationScoped
    @Produces
    public Handle validacionConexion(){
        conexion = Jdbi.create(dbURL,dbUser,dbPassword);
        System.out.println("op2: "+ dbUser);
        System.out.println("op2: "+ dbPassword);
        System.out.println("op2: "+ dbURL);
        return conexion.open();
    }
}
