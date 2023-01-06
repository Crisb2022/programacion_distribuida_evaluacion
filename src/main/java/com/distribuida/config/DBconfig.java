package com.distribuida.config;


import com.zaxxer.hikari.HikariDataSource;
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

import javax.sql.DataSource;

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

    @Inject
    @ConfigProperty(name="db.name")
    String dbName;


    @PostConstruct
    public void init(){
        validacionConexion();
    }

    public void test() {

    }

    @Produces
    @ApplicationScoped
    //Hikari
    public Jdbi validacionConexion() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(dbName);
        dataSource.setJdbcUrl(dbURL);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        Jdbi conexion = Jdbi.create(dataSource);
        return conexion;
    }
}
