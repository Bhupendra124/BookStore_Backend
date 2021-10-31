//package com.bridgelabz.bookstore.response;
//
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class BookResponse {
//	BookData book;
//
//	private Object obj;
//	double rate;
//
//
//	public Object getObj() {
//		return obj;
//	}
//
//	public void setObj(Object obj) {
//		this.obj = obj;
//	}
//
//	int statusCode;
//	String response;
//	List<BookData> bookList;
//
//	public BookData getBook() {
//		return book;
//	}
//
//	public void setBook(BookData book) {
//		this.book = book;
//	}
//
//	public int getStatusCode() {
//		return statusCode;
//	}
//
//	public void setStatusCode(int statusCode) {
//		this.statusCode = statusCode;
//	}
//
//	public String getResponse() {
//		return response;
//	}
//
//	public void setResponse(String response) {
//		this.response = response;
//	}
//
//	public List<BookData> getBookList() {
//		return bookList;
//	}
//
//	public void setBookList(List<BookData> bookList) {
//		this.bookList = bookList;
//	}
//
//	public BookResponse() {
//
//	}
//
////	public BookResponse(String response, List<Book> bookList) {
////		super();
////
////		this.response = response;
////		this.bookList = bookList;
////	}
//
//	public BookResponse(String response, Object obj) {
//		super();
//		this.obj = obj;
//
//		this.response = response;
//	}
//
//	public BookResponse(int statusCode, String response) {
//		super();
//		this.statusCode = statusCode;
//		this.response = response;
//	}
//
//}