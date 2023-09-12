package com.example.lib_man_sys.service;

import com.example.lib_man_sys.Enum.CardStatus;
import com.example.lib_man_sys.model.LibraryCard;
import com.example.lib_man_sys.model.Student;
import com.example.lib_man_sys.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student) {
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNo(UUID.randomUUID().toString());
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard);
        Student savedStudent = studentRepository.save(student);

        return "Student saved successfully !!!";
    }

    public Student getStudent(int regNo) {
        Optional<Student> optionalStudent = studentRepository.findById(regNo);
        if(optionalStudent.isPresent()){
            return optionalStudent.get();
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
//        studentRepository.updateAge(regNo, newAge);
//        Optional<Student> updatedStudent = studentRepository.findById(regNo);
//        return updatedStudent.isPresent() ? updatedStudent.get() : null;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getMaleStudents() {
        return studentRepository.getMaleStudents();
    }
}
