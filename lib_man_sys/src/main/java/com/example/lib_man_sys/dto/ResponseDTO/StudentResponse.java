package com.example.lib_man_sys.dto.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentResponse {
    String name;

    int age;

    String email;

    LibraryCardResponse libraryCardResponse;
}
