package com.example.lib_man_sys.service;

import com.example.lib_man_sys.dto.RequestDTO.StudentRequest;
import com.example.lib_man_sys.dto.ResponseDTO.StudentResponse;

import java.util.List;

public interface StudentService {
    public StudentResponse addStudent(StudentRequest studentRequest);

    public StudentResponse getStudent(int regNo);

    public void deleteStudent(int regNO);

    public StudentResponse updateAge(int regNo, int newAge);

    public List<StudentResponse> getAllStudents();

    public List<StudentResponse> getMaleStudents();
}
