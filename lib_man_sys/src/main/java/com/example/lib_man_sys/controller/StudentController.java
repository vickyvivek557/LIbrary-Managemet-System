package com.example.lib_man_sys.controller;

import com.example.lib_man_sys.dto.RequestDTO.StudentRequest;
import com.example.lib_man_sys.dto.ResponseDTO.StudentResponse;
import com.example.lib_man_sys.service.StudentService;
import com.example.lib_man_sys.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity addStudetn(@RequestBody StudentRequest studentRequest){
        StudentResponse response = studentService.addStudent(studentRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int regNo){
        StudentResponse student = studentService.getStudent(regNo);
        if(student != null){
            return new ResponseEntity(student, HttpStatus.FOUND);
        }
        return new ResponseEntity("Invalid regNo !!!", HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int regNO){
        studentService.deleteStudent(regNO);
        return "Studetnt deleated successfully!!";
    }
    @PutMapping("/update_age")
    public ResponseEntity updateAge(@RequestParam("id") int regNo, @RequestParam("age") int newAge){
        Student student = studentService.updateAge(regNo, newAge);
        if(student != null){
            return new ResponseEntity(student, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity("Invalid regNo !!!", HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/get_all")
    public ResponseEntity getAllStudents(){
        List<String> studentList = studentService.getAllStudents();
        if(studentList.size() > 0){
            return new ResponseEntity(studentList, HttpStatus.FOUND);
        }
        return new ResponseEntity("NO any student present in Database.", HttpStatus.NO_CONTENT);
    }
    @GetMapping("/get_all_male")
    public ResponseEntity getMaleStudents(){
        List<Student> maleStudentsList = studentService.getMaleStudents();
        if(maleStudentsList.size() > 0){
            return new ResponseEntity(maleStudentsList, HttpStatus.FOUND);
        }
        return new ResponseEntity("No male student found!!!", HttpStatus.NO_CONTENT);
    }
}
