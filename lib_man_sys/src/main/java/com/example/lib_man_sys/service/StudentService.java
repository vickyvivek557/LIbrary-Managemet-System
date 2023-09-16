package com.example.lib_man_sys.service;

import com.example.lib_man_sys.Enum.CardStatus;
import com.example.lib_man_sys.Enum.Gender;
import com.example.lib_man_sys.dto.RequestDTO.StudentRequest;
import com.example.lib_man_sys.dto.ResponseDTO.StudentResponse;
import com.example.lib_man_sys.model.LibraryCard;
import com.example.lib_man_sys.model.Student;
import com.example.lib_man_sys.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public StudentResponse addStudent(StudentRequest studentRequest) {
        //convert the request DTO into model
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());
        student.setRegNo(studentRequest.getAge());
        student.setEmail(studentRequest.getEmail());
        student.setGender(studentRequest.getGender());

        //assign lib card
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNo(UUID.randomUUID().toString());
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);

        //set lib_card to student
        student.setLibraryCard(libraryCard);

        //save the student in db it will auto save both lib and student
        Student savedStudent = studentRepository.save(student);

        //convert saved model to response DTO
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setName(savedStudent.getName());
        studentResponse.setEmail(savedStudent.getEmail());
        studentResponse.setMessage("you have been registered successfully.");
        studentResponse.setCardIssudNO(savedStudent.getLibraryCard().getCardNo());

        return studentResponse;
    }

    public StudentResponse getStudent(int regNo) {
        Optional<Student> optionalStudent = studentRepository.findById(regNo);
        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setName(student.getName());
            studentResponse.setEmail(student.getEmail());
            studentResponse.setCardIssudNO(student.getLibraryCard().getCardNo());
            return studentResponse;
        }
        return null;
    }
    public void deleteStudent(int regNO) {
        studentRepository.deleteById(regNO);
    }

    public Student updateAge(int regNo, int newAge) {
        Optional<Student> optionalStudent = studentRepository.findById(regNo);
        if(optionalStudent.isPresent()){
            optionalStudent.get().setAge(newAge);
            return studentRepository.save(optionalStudent.get());
        }
        return null;
    }

    public List<String> getAllStudents() {
        List<String> studentList = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        for(Student s : students){
            studentList.add(s.getName());
        }
        return studentList;
    }

    public List<Student> getMaleStudents() {
        return studentRepository.findByGender();
    }
}
