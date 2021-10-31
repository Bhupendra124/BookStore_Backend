package com.bridgelabz.bookstore.entity;

import com.bridgelabz.bookstore.dto.BookDto;
import lombok.Data;

import javax.persistence.*;

@Data
public class BookData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    private String name;
    private String author;
    private String description;
    private String logo;
    private Float price;
    private Long quantity;

    public BookData() {
    }

    public BookData(BookDto bookDto) {
        this.updateBook(bookDto);
    }

    public void updateBook(BookDto bookDto) {
        this.name = bookDto.name;
        this.author = bookDto.author;
        this.description = bookDto.description;
        this.logo = bookDto.logo;
        this.price = bookDto.price;
        this.quantity = bookDto.quantity;
    }
}