package com.example.attendance.controller;

import com.example.attendance.facade.AttendanceFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/v2/attendance")
@Slf4j
public class AttendanceController {

    @Autowired
    AttendanceFacade attendanceFacade;

    @PostMapping("/get")
    public ResponseEntity getByCourseAndDate(@RequestBody List<String> inputs){
        try{
            return new ResponseEntity(attendanceFacade.findNameByCourseAndDate(inputs.get(0), inputs.get(1)), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
