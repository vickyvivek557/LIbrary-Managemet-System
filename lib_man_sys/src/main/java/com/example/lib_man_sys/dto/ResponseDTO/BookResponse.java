package com.example.lib_man_sys.dto.ResponseDTO;

import com.example.lib_man_sys.Enum.Genre;
import com.example.lib_man_sys.model.Author;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookResponse {
    String title;

    int noOfPages;

    Genre genre;

    double cost;

    Author author;
}
