package com.example.lib_man_sys.service;

import com.example.lib_man_sys.dto.RequestDTO.BookRequest;
import com.example.lib_man_sys.dto.ResponseDTO.BookResponse;
import com.example.lib_man_sys.model.Book;

public interface BookService {
    public BookResponse addBook(BookRequest bookRequest);
}
