package com.example.student_crud.service;

import com.example.student_crud.dto.CreateStudentReqDto;
import com.example.student_crud.dto.CreateStudentRespDto;
import com.example.student_crud.dto.UpdateStudentReqDto;
import com.example.student_crud.dto.UpdateStudentRespDto;
import com.example.student_crud.entity.Student;
import com.example.student_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    public CreateStudentRespDto createStudent(CreateStudentReqDto studentRespDto){
       Student student = mapToStudent(studentRespDto);
       repository.save(student);
       return MapToResponceDto(student);
    }


    private CreateStudentRespDto MapToResponceDto(Student student) {
        CreateStudentRespDto studentRespDto = new CreateStudentRespDto();
        studentRespDto.setId(student.getId());
        studentRespDto.setName(student.getName());
        studentRespDto.setEmail(student.getEmail());
        studentRespDto.setPhone(student.getPhone());
        studentRespDto.setGender(student.getGender());
        studentRespDto.setDob(student.getDob());
        studentRespDto.setBranch(student.getBranch());
        studentRespDto.setYear(student.getYear());
        studentRespDto.setRollNo(student.getRollNo());
        studentRespDto.setCity(student.getCity());
        return studentRespDto;
    }

    private Student mapToStudent(CreateStudentReqDto studentRespDto) {
        Student student = new Student();

        student.setName(studentRespDto.getName());
        student.setEmail(studentRespDto.getEmail());
        student.setPhone(studentRespDto.getPhone());
        student.setGender(studentRespDto.getGender());
        student.setDob(studentRespDto.getDob());
        student.setBranch(studentRespDto.getBranch());
        student.setYear(studentRespDto.getYear());
        student.setRollNo(studentRespDto.getRollNo());
        student.setCity(studentRespDto.getCity());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    public UpdateStudentRespDto updateById(long id , UpdateStudentReqDto studentReqDto) {
        Optional<Student> student = repository.findbyIdAndIsDeletedIsFalse(id);
    }
}
