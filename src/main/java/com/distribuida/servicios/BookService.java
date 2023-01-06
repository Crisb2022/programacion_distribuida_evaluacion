package com.distribuida.servicios;

import com.distribuida.db.Book;
import jakarta.ws.rs.PathParam;

import java.util.List;

public interface BookService {
    Book findById(Integer id);
    List <Book> findAll();
    void insert(Book book);
    void update(Integer id, Book book);
    void delete(Integer id);
}
