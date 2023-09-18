package com.example.lib_man_sys.controller;

import com.example.lib_man_sys.dto.RequestDTO.BookRequest;
import com.example.lib_man_sys.dto.ResponseDTO.BookResponse;
import com.example.lib_man_sys.model.Book;
import com.example.lib_man_sys.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    public ResponseEntity addBook(BookRequest bookRequest){
        try {
            BookResponse response = bookService.addBook(bookRequest);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
