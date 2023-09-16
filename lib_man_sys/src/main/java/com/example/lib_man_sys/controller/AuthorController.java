package com.example.lib_man_sys.controller;

import com.example.lib_man_sys.model.Author;
import com.example.lib_man_sys.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    public ResponseEntity addAuthor(Author author){
        authorService.addAuthor(author);
        return new ResponseEntity("Author added successfully !!", HttpStatus.CREATED);
    }
}
