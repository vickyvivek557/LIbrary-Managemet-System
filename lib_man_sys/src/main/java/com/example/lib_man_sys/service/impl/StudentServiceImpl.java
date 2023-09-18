package com.example.lib_man_sys.service.impl;

import com.example.lib_man_sys.Enum.Gender;
import com.example.lib_man_sys.dto.RequestDTO.StudentRequest;
import com.example.lib_man_sys.dto.ResponseDTO.StudentResponse;
import com.example.lib_man_sys.model.LibraryCard;
import com.example.lib_man_sys.model.Student;
import com.example.lib_man_sys.repository.StudentRepository;
import com.example.lib_man_sys.service.StudentService;
import com.example.lib_man_sys.transformer.LibraryCardTransformer;
import com.example.lib_man_sys.transformer.StudentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentResponse addStudent(StudentRequest studentRequest) {
        //convert the request DTO into model
        Student student = StudentTransformer.StudentRequestToStudent(studentRequest);

        //prepare lib card
        LibraryCard libraryCard = LibraryCardTransformer.PrepareLibCard();

        //link lib card to student
        libraryCard.setStudent(student);

        //link student to this lib card
        student.setLibraryCard(libraryCard);

        //save the student in db it will auto save both lib and student
        Student savedStudent = studentRepository.save(student);

        //convert saved model to response DTO
        StudentResponse studentResponse = StudentTransformer.StudentToStudentResponse(savedStudent);

        return studentResponse;
    }

    @Override
    public StudentResponse getStudent(int regNo) {
        Optional<Student> optionalStudent = studentRepository.findById(regNo);
        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            StudentResponse studentResponse = StudentTransformer.StudentToStudentResponse(student);
            return studentResponse;
        }
        return null;
    }

    @Override
    public void deleteStudent(int regNO) {
        studentRepository.deleteById(regNO);
    }

    @Override
    public StudentResponse updateAge(int regNo, int newAge) {
        Optional<Student> optionalStudent = studentRepository.findById(regNo);
        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            student.setAge(newAge);
            Student savedStudent = studentRepository.save(student);
            return StudentTransformer.StudentToStudentResponse(savedStudent);
        }
        return null;
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        List<StudentResponse> studentResponseList = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        for(Student student : students){
            StudentResponse studentResponse = StudentTransformer.StudentToStudentResponse(student);
            studentResponseList.add(studentResponse);
        }
        return studentResponseList;
    }

    @Override
    public List<StudentResponse> getMaleStudents() {
        List<StudentResponse> studentResponseList = new ArrayList<>();
        List<Student> students = studentRepository.findByGender(Gender.MALE);
        for(Student student : students){
            StudentResponse studentResponse = StudentTransformer.StudentToStudentResponse(student);
            studentResponseList.add(studentResponse);
        }
        return studentResponseList;
    }
}
