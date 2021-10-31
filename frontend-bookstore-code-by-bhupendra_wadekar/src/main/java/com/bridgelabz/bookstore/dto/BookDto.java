package com.bridgelabz.bookstore.dto;

import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class BookDto {
	public String name;
	public String author;
	public String description;
	public String logo;
	public Float price;
	public Long quantity;
	
}