package com.example.lib_man_sys.transformer;

import com.example.lib_man_sys.dto.RequestDTO.AuthorRequest;
import com.example.lib_man_sys.dto.ResponseDTO.AuthorResponse;
import com.example.lib_man_sys.model.Author;

public class AuthorTransformer {

    public static Author AuthorRequestToAuthor(AuthorRequest authorRequest){
        return Author.builder()
                .name(authorRequest.getName())
                .age(authorRequest.getAge())
                .email(authorRequest.getEmail())
                .build();
    }

    public static AuthorResponse authorToAuthorResponse(Author author){
        return AuthorResponse.builder()
                .name(author.getName())
                .email(author.getEmail())
                .lastActive(author.getLastActive())
                .bookList(author.getBooks())
                .build();
    }
}
