package com.example.attendance.controller;

import com.example.attendance.models.Course;
import com.example.attendance.service.CourseService;
import com.example.attendance.service.impl.CourseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/attendance")
@Slf4j
public class CourseController {
    @Autowired
    CourseService csi;

    @PostMapping("/courses")
    public ResponseEntity addAttendance(@RequestBody Course course){
        try{
            Course markedCourse = csi.save(course);
            return new ResponseEntity(markedCourse, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity getByCourse(@PathVariable("courseId") String courseId){
        try{
            return new ResponseEntity(csi.findByCourseId(courseId), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getDate/{date}")
    public ResponseEntity getByDate(@PathVariable("date") String date){
        try{
            return new ResponseEntity(csi.findByDate(date), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(null, HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("/get")
    public ResponseEntity getByCourseAndDate(@RequestBody List<String> inputs){
        try{
            return new ResponseEntity(csi.findByCourseNameAndDate(inputs.get(0), inputs.get(1)), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
