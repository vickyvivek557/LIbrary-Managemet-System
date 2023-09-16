package com.example.lib_man_sys.dto.ResponseDTO;

import com.example.lib_man_sys.Enum.CardStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryCardResponse {
    String cardNo;

    CardStatus cardStatus;

    Date issueDate;
}
