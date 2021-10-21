package com.bridgelabz.bookstore.dto;

import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class BookDto {
	private String bookName;
	private Long noOfBooks;
	private Double price;
	private String authorName;
	private String image;
	private String bookDetails;
	private String userId;
	
}