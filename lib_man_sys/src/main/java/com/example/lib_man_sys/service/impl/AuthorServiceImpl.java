package com.example.lib_man_sys.service.impl;

import com.example.lib_man_sys.dto.RequestDTO.AuthorRequest;
import com.example.lib_man_sys.dto.ResponseDTO.AuthorResponse;
import com.example.lib_man_sys.model.Author;
import com.example.lib_man_sys.repository.AuthorRepository;
import com.example.lib_man_sys.service.AuthorService;
import com.example.lib_man_sys.transformer.AuthorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public AuthorResponse addAuthor(AuthorRequest authorRequest) {
        //create author from author request
        Author author = AuthorTransformer.AuthorRequestToAuthor(authorRequest);

        //save author to database
        Author savedAuthor = authorRepository.save(author);

        //create author response and return
        AuthorResponse authorResponse = AuthorTransformer.authorToAuthorResponse(savedAuthor);

        return authorResponse;
    }
}
