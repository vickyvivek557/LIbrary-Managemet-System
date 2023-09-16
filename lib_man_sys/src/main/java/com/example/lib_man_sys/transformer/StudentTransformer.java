package com.example.lib_man_sys.transformer;

import com.example.lib_man_sys.dto.RequestDTO.StudentRequest;
import com.example.lib_man_sys.dto.ResponseDTO.LibraryCardResponse;
import com.example.lib_man_sys.dto.ResponseDTO.StudentResponse;
import com.example.lib_man_sys.model.Student;

public class StudentTransformer {
    public static Student StudentRequestToStudent(StudentRequest studentRequest){
        return Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .gender(studentRequest.getGender())
                .build();
    }

    public static StudentResponse StudentToStudentResponse(Student student){
        LibraryCardResponse libraryCardResponse = LibraryCardTransformer.LibCardResponseForStudetn(student);
        return StudentResponse.builder()
                .name(student.getName())
                .email(student.getEmail())
                .age(student.getAge())
                .libraryCardResponse(libraryCardResponse)
                .build();
    }
}
