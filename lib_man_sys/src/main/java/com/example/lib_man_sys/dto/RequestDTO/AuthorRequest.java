package com.example.lib_man_sys.dto.RequestDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class AuthorRequest {
    String name;

    int age;

    String email;

}
