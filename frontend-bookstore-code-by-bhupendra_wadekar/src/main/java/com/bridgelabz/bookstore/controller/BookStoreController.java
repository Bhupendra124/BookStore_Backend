package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.entity.Book;
import com.bridgelabz.bookstore.response.BookResponse;
import com.bridgelabz.bookstore.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BookStoreController {

    @Autowired
    IBookService bookservice;

    @PostMapping("books/{imageName}")
    public ResponseEntity<BookResponse> addBook(@PathVariable String imageName, @RequestBody BookDto information, @RequestHeader("token") String token) {

        boolean res=bookservice.addBooks(imageName, information ,token);
        if(res)
            return ResponseEntity.status(HttpStatus.CREATED).body(new BookResponse(200, "Book Added Successfully.."));
        else
            return ResponseEntity.status(HttpStatus.CREATED).body(new BookResponse(400, "The Book details not added "));
    }



    @GetMapping("books/")
    public ResponseEntity<BookResponse> getBooks(@RequestHeader("token") String token) {
        List<Book> books = bookservice.getBookInfo(token);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new BookResponse("The Book details are", books));
    }
}
