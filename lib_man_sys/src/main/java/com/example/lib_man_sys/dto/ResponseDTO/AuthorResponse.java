package com.example.lib_man_sys.dto.ResponseDTO;

import com.example.lib_man_sys.model.Book;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuthorResponse {
    String name;

    String email;

    Date lastActive;

    List<Book> bookList = new ArrayList<>();
}
