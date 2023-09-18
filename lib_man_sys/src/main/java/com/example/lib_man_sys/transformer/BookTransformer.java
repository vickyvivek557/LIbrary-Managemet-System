package com.example.lib_man_sys.transformer;

import com.example.lib_man_sys.dto.RequestDTO.BookRequest;
import com.example.lib_man_sys.dto.ResponseDTO.BookResponse;
import com.example.lib_man_sys.model.Book;

public class BookTransformer {
    public static Book BookRequestToBook(BookRequest bookRequest){
        return Book.builder()
                .title(bookRequest.getTitle())
                .genre(bookRequest.getGenre())
                .cost(bookRequest.getCost())
                .author(bookRequest.getAuthor())
                .noOfPages(bookRequest.getNoOfPages())
                .build();
    }

    public static BookResponse BooktoBookResponse(Book book){
        return BookResponse.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .cost(book.getCost())
                .genre(book.getGenre())
                .noOfPages(book.getNoOfPages())
                .build();
    }
}
