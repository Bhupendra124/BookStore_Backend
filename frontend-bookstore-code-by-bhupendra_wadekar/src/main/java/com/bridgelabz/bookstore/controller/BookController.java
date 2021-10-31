package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.BookDto;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {

    @Autowired
    IBookService bookService;

    @PostMapping("/add")
    ResponseEntity<ResponseDTO> addBook(@RequestBody BookDto bookDto){

        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Post call success",
                bookService.addBook(bookDto)), HttpStatus.OK);
    }

    @GetMapping("/all")
    ResponseEntity<ResponseDTO> getBooks(){
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Get call success",
                bookService.getBooks()), HttpStatus.OK);
    }

    @GetMapping("/bookId")
    public ResponseEntity<ResponseDTO> getBookById(@PathVariable("bookId") Long Book_id) {
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Get call success",
                bookService.getBookById(Book_id)), HttpStatus.OK);
    }

    @PutMapping("/update/{bookId}")
    ResponseEntity<ResponseDTO> updateBook(@PathVariable("bookId") Long Book_id, @RequestBody BookDto bookDto){

        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Put call success",
                bookService.updateBook(Book_id, bookDto)), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("deleted book data with bookId :", bookId),
                HttpStatus.OK);
    }


//    @PostMapping("books/bookimage/{bookId}")
//    public ResponseEntity<ResponseDTO> uploadImage(@RequestParam("imageFile") MultipartFile file, @RequestHeader String token, @PathVariable long bookId)  {
//        String imageName=file.getOriginalFilename();
//        boolean res=bookservice.uploadBookImage(bookId,imageName,token);
//        if(res)
//            return ResponseEntity.status(HttpStatus.OK).body(new BookResponse(202, "Image Uploaded Succesfully"));
//        else
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new BookResponse(203,"error"));
//    }
}