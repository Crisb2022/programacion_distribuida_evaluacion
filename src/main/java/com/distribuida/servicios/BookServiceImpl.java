package com.distribuida.servicios;

import com.distribuida.config.DBconfig;
import com.distribuida.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import org.jdbi.v3.core.Handle;

import javax.swing.tree.RowMapper;
import java.util.*;

@ApplicationScoped
public class BookServiceImpl implements BookService{

    @Inject private DBconfig configuracion;

    private List <Book> listaBD = new ArrayList<>();

    public Book findById(Integer id) {
        String comand = "SELECT * FROM books WHERE id=?";
        Book book = null;

        try {
            Handle handle = configuracion.validacionConexion().open();
            book = handle.select(comand, id)
                    .mapToBean(Book.class)
                    .one();
            handle.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }
    public List<Book> findAll() {
        String comand = "SELECT * FROM books";
        try {
            Handle handle = configuracion.validacionConexion().open();
            listaBD = handle.createQuery(comand)
                    .mapToBean(Book.class)
                    .list();
            handle.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaBD;
    }

    public void insert(Book book){
        Handle handle = null;
        String comand = "INSERT INTO books(isbn, author, price, title) VALUES (?, ?, ?, ?)";
        try {
            handle = configuracion.validacionConexion().open();
            handle.execute(comand,book.getIsbn(), book.getAuthor(),book.getPrice(), book.getTitle());
            handle.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(Integer id, Book book){
        Handle handle = null;
        String comand = "UPDATE books SET isbn = :isbn, title = :title, author = :author, price = :price WHERE id = :id";
        try {
            handle = configuracion.validacionConexion().open();
            handle.createUpdate(comand)
                    .bind("isbn", book.getIsbn())
                    .bind("title", book.getTitle())
                    .bind("author", book.getAuthor())
                    .bind("price", book.getPrice())
                    .bind("id",book.getId())
                    .execute();
            handle.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void delete(Integer id){
        Handle handle = null;
        String comand = "DELETE FROM books WHERE id = " + id;
        System.out.println("--------------"+id+"-----------------");
        try {
            handle = configuracion.validacionConexion().open();
            handle.execute(comand);
            handle.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
