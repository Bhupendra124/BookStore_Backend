package com.bridgelabz.bookstore.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bookinfo")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private Long userId;
    private String bookName;
    private Long noOfBooks;
    private Double price;
    private String authorName;
    @Column(columnDefinition="TEXT")
    private String bookDetails;
    private LocalDateTime createdDateAndTime;
    private LocalDateTime updatedDateAndTime;
    private String status;
    private String image;
}
