package com.example.attendance.service.impl;

import com.example.attendance.models.Student;
import com.example.attendance.repositories.StudentRepository;
import com.example.attendance.service.StudentService;
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
    public Student save(Student student) {
        if(!(student.getName() == null || student.getName().isBlank() || student.getName().matches(".*\\d.*"))) {
            return studentRepository.save(student);
        }
        return null;

    }

    @Override
    public Optional<Student> findById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findByList(List<String> ids) {
        List listOfStudents = new ArrayList<>();
        studentRepository.findAllById(ids).forEach(listOfStudents::add);
        return listOfStudents;
    }
}
