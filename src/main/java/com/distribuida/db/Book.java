package com.distribuida.db;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String isbn;
    private String title;
    private String author;
    private Double price ;

}
