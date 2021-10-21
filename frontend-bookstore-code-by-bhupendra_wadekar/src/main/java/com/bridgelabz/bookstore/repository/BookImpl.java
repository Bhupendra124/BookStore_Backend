package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.entity.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookImpl extends JpaRepository<Book, Long> {
    @Query("from Book where book_id=:id")
    Book fetchbyId(Long id);

    @Query("from Book where book_name=:name")
    Book fetchbyBookName(String name);

//    @Query( value = "select * from book", nativeQuery = true)
//    List<Book> findAllPage(Pageable pageable);

}
