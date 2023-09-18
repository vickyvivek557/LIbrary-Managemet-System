package com.example.lib_man_sys.service;

import com.example.lib_man_sys.dto.RequestDTO.AuthorRequest;
import com.example.lib_man_sys.dto.ResponseDTO.AuthorResponse;
import com.example.lib_man_sys.model.Author;

public interface AuthorService {
    public AuthorResponse addAuthor(AuthorRequest authorRequest);
}
