package com.example.student_crud.controller;

import com.example.student_crud.dto.CreateStudentReqDto;
import com.example.student_crud.dto.GetStudentResponceDto;
import com.example.student_crud.dto.UpdateStudentReqDto;
import com.example.student_crud.dto.UpdateStudentRespDto;
import com.example.student_crud.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<GetStudentResponceDto> createStudent(CreateStudentReqDto studentReqDto){
        GetStudentResponceDto studentRespDto =  studentService.createStudent(studentReqDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentRespDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UpdateStudentRespDto> updateById(@PathVariable long id,
                                                           UpdateStudentReqDto studentReqDto){
       UpdateStudentRespDto studentResp = studentService.updateById(id,studentReqDto);
       if(studentResp==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
       return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GetStudentResponceDto> getById(@PathVariable long id){
      GetStudentResponceDto studentResponceDto = studentService.getById(id);
    }
}
