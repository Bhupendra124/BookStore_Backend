package com.bridgelabz.bookstore.service;
import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.entity.BookData;

import java.util.List;

public interface IBookService {
    List<BookData> getBooks();
    BookData getBookById(Long book_id);
    List<BookData> getBookByName(String book_name);
    BookData addBook(BookDto bookDto);
    BookData updateBook(Long book_id, BookDto bookDto);
    //    void changeBookQuantity(String token,Long book_id, Long quantity);
//    void changeBookPrice(Long book_id, Float price);
    void deleteBook(Long book_id);

    boolean uploadBookImage(long bookId, String imageName, String token);
}