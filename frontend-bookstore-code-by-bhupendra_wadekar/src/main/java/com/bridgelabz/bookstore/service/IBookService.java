package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.entity.Book;

import java.util.List;

public interface IBookService {
    boolean addBooks(String imageName, BookDto information, String token);

    List<Book> getBookInfo(String token);

}
