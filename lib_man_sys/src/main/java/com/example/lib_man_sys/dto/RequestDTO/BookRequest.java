package com.example.lib_man_sys.dto.RequestDTO;

import com.example.lib_man_sys.Enum.Genre;
import com.example.lib_man_sys.model.Author;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequest {
    String title;

    int noOfPages;

    Genre genre;

    double cost;

    Author author;
}
