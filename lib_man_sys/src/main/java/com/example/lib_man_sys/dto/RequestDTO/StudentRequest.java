package com.example.lib_man_sys.dto.RequestDTO;

import com.example.lib_man_sys.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentRequest {
    String name;

    int age;

    String email;

    Gender gender;
}
