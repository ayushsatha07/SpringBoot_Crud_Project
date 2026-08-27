package com.example.student_crud.repository;

import com.example.student_crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
  Optional<Student> findByIdAndIsDeletedIsFalse();
}
