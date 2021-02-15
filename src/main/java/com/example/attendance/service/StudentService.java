package com.example.attendance.service;

import com.example.attendance.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student save(Student student);
    Optional<Student> findById(String id);
    List<Student> findByList(List<String> id);
}
