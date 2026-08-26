package com.example.student_crud.controller;

import com.example.student_crud.dto.CreateStudentReqDto;
import com.example.student_crud.dto.CreateStudentRespDto;
import com.example.student_crud.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<CreateStudentRespDto> createStudent(CreateStudentReqDto studentReqDto){
   CreateStudentRespDto studentRespDto =  studentService.createStudent(studentReqDto);

    }


}
