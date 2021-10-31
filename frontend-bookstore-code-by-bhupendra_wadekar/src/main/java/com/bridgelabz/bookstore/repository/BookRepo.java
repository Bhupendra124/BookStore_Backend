package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.entity.BookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface    BookRepo extends JpaRepository<BookData, Long> {
    @Query(value ="select * from bookinfo where name = :book_name", nativeQuery = true)
    public List<BookData> findByName(String book_name);
}