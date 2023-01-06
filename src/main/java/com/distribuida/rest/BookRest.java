package com.distribuida.rest;

import com.distribuida.config.DBconfig;
import com.distribuida.db.Book;
import com.distribuida.servicios.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@ApplicationScoped
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookRest {
    @Inject private BookService bookService;
    @Inject private DBconfig config;

    @GET
    @Path("/{id}")
    public Book findById(@PathParam("id") Integer id){
        config.test();
        return bookService.findById(id);
    }

    @GET
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @POST
    public void insert(Book book){
        bookService.insert(book);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Integer id, Book book){
        bookService.update(id, book);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id){
        bookService.delete(id);
    }

}
