package com.example.attendance.controller;

import com.example.attendance.models.Student;
import com.example.attendance.service.StudentService;
import com.example.attendance.service.impl.StudentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/v1/attendance")
@Slf4j
public class StudentController {
    @Autowired
    StudentService ssi;


    @GetMapping("/students/{id}")
    public ResponseEntity getStudentById(@PathVariable("id") String id)
    {
        try
        {
            return new ResponseEntity<>(ssi.findById(id).get(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/get")
    public ResponseEntity<List> getList(@RequestBody List<String> ids)
    {
        try
        {
            return new ResponseEntity<>(ssi.findByList(ids), HttpStatus.OK);
        }
        catch (Exception e)
        {
            log.error(e.getMessage(),e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/students")
    public ResponseEntity addStudent(@RequestBody Student student)
    {
        try
        {
            return new ResponseEntity<>(ssi.save(student), HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
