package com.example.lib_man_sys.dto.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentResponse {
    String name;

    String email;

    String message;

    String cardIssudNO;
}
