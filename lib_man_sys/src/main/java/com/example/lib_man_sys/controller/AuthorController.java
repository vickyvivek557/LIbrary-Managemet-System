package com.example.lib_man_sys.controller;

import com.example.lib_man_sys.dto.RequestDTO.AuthorRequest;
import com.example.lib_man_sys.dto.ResponseDTO.AuthorResponse;
import com.example.lib_man_sys.model.Author;
import com.example.lib_man_sys.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorServiceImpl authorServiceImpl;

    public ResponseEntity addAuthor(AuthorRequest authorRequest){
        AuthorResponse authorResponse = authorServiceImpl.addAuthor(authorRequest);
        return new ResponseEntity(authorResponse, HttpStatus.CREATED);
    }
}
