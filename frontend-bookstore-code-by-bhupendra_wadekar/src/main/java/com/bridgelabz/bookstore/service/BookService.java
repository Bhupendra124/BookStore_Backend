package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.entity.BookData;
import com.bridgelabz.bookstore.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    BookRepo bookRepo;

    @Override
    public List<BookData> getBooks() {
        return bookRepo.findAll();
    }

    @Override
    public BookData getBookById(Long book_id) {
        return bookRepo.findById(book_id).orElse(null);
    }

    @Override
    public List<BookData> getBookByName(String book_name) {
        return bookRepo.findByName(book_name);
    }

    @Override
    public BookData addBook(BookDto bookDto) {
        BookData bookData = new BookData(bookDto);
        return bookRepo.save(bookData);
    }

    @Override
    public BookData updateBook(Long book_id, BookDto bookDto) {
        BookData bookData = this.getBookById(book_id);
        bookData.updateBook(bookDto);
        return bookRepo.save(bookData);
    }

    @Override
    public void deleteBook(Long book_id) {
        BookData bookData = this.getBookById(book_id);
        bookRepo.delete(bookData);
    }

    @Override
    public boolean uploadBookImage(long bookId, String imageName, String token) {
        return false;
    }
}