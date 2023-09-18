package com.example.lib_man_sys.service.impl;

import com.example.lib_man_sys.dto.RequestDTO.BookRequest;
import com.example.lib_man_sys.dto.ResponseDTO.BookResponse;
import com.example.lib_man_sys.exception.AuthorNotFoundException;
import com.example.lib_man_sys.model.Author;
import com.example.lib_man_sys.model.Book;
import com.example.lib_man_sys.repository.AuthorRepository;
import com.example.lib_man_sys.service.BookService;
import com.example.lib_man_sys.transformer.BookTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class BookServiceImpl implements BookService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public BookResponse addBook(BookRequest bookRequest){
        //check if author exists or not
        Optional<Author> optionalAuthor = authorRepository.findById(bookRequest.getAuthor().getId());

        if(optionalAuthor.isEmpty()){
            throw new AuthorNotFoundException("This author is not present !!");
        }
        //else get the author
        Author author = optionalAuthor.get();

        //create book from book request
        Book book = BookTransformer.BookRequestToBook(bookRequest);

        //add book in authors book list
        author.getBooks().add(book);

        //save author. Both will be saved author and book
        authorRepository.save(author);

        //return book response
        BookResponse bookResponse = BookTransformer.BooktoBookResponse(book);
        return bookResponse;
    }
}
