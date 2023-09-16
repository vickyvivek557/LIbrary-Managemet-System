package com.example.lib_man_sys.transformer;

import com.example.lib_man_sys.Enum.CardStatus;
import com.example.lib_man_sys.dto.ResponseDTO.LibraryCardResponse;
import com.example.lib_man_sys.model.LibraryCard;
import com.example.lib_man_sys.model.Student;

import java.util.UUID;

public class LibraryCardTransformer {
    public static LibraryCard PrepareLibCard(){
        return LibraryCard.builder()
                .cardNo(UUID.randomUUID().toString())
                .cardStatus(CardStatus.ACTIVE)
                .build();
    }

    public static LibraryCardResponse LibCardResponseForStudetn(Student student){
        return LibraryCardResponse.builder()
                .cardNo(student.getLibraryCard().getCardNo())
                .issueDate(student.getLibraryCard().getIssueDate())
                .cardStatus(student.getLibraryCard().getCardStatus())
                .build();
    }
}
